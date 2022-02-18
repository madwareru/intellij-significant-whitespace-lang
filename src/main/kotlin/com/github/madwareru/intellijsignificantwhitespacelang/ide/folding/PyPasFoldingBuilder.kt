package com.github.madwareru.intellijsignificantwhitespacelang.ide.folding

import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.*
import com.github.madwareru.intellijsignificantwhitespacelang.util.isElementOfType
import com.github.madwareru.intellijsignificantwhitespacelang.util.scrollLeft
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiWhiteSpace
import com.intellij.psi.util.PsiTreeUtil

class PyPasFoldingBuilder : CustomFoldingBuilder(), DumbAware {
    override fun buildLanguageFoldRegions(
        descriptors: MutableList<FoldingDescriptor>,
        root: PsiElement,
        document: Document,
        quick: Boolean
    ) {
        if (root !is PyPasFile) return
        val visitor = PyPasFoldingVisitor(descriptors)
        PsiTreeUtil.processElements(root) { it.accept(visitor); true }
    }

    override fun getLanguagePlaceholderText(node: ASTNode, range: TextRange): String = "{...}"

    override fun isRegionCollapsedByDefault(node: ASTNode): Boolean = false
}

private class PyPasFoldingVisitor(private val descriptors: MutableList<FoldingDescriptor>) : PyPasRecursiveVisitor() {
    override fun visitDefinitions(o: PyPasDefinitions) {
        val currentRange = o.textRange
        descriptors += FoldingDescriptor(o.node, currentRange)
        super.visitDefinitions(o)
    }

    override fun visitRecordBody(o: PyPasRecordBody) {
        val currentRange = o.textRange
        val varDefs = o.varDefinitions
        val lastChild = getLastChildForVarDefinitions(varDefs)
        if (lastChild != null) {
            val range = TextRange(currentRange.startOffset, lastChild.textRange.endOffset)
            descriptors += FoldingDescriptor(o.node, range)
        }
        super.visitRecordBody(o)
    }

    override fun visitBlockStatementsBody(o: PyPasBlockStatementsBody) {
        val currentRange = o.textRange
        val statements = o.statements
        if (statements != null) {
            val lastChild = getLastChildForStatements(statements)
            if (lastChild != null) {
                val range = TextRange(currentRange.startOffset, lastChild.textRange.endOffset)
                descriptors += FoldingDescriptor(o.node, range)
            }
        }
        super.visitBlockStatementsBody(o)
    }

    fun getLastChildForVarDefinitions(varDefinitions: PyPasVarDefinitions): PsiElement? {
        var lastChild = varDefinitions.varDefinitionList.lastOrNull()?.lastChild
        while (lastChild != null && shouldScrollLeft(lastChild)) {
            lastChild = lastChild.scrollLeft()
        }
        return lastChild
    }

    fun getLastChildForStatements(statements: PyPasStatements): PsiElement? {
        var lastChild = statements.statementList.lastOrNull()?.lastChild
        while (lastChild != null && shouldScrollLeft(lastChild)) {
            lastChild = lastChild.scrollLeft()
        }
        return lastChild
    }

    fun shouldScrollLeft(element: PsiElement): Boolean =
        element.isElementOfType(PyPasTypes.NEW_LINE) ||
                element.isElementOfType(PyPasTypes.UNINDENT) ||
                element is PsiWhiteSpace
}