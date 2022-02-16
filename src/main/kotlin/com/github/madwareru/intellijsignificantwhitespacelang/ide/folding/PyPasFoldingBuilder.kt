package com.github.madwareru.intellijsignificantwhitespacelang.ide.folding

import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.*
import com.intellij.lang.ASTNode
import com.intellij.lang.folding.CustomFoldingBuilder
import com.intellij.lang.folding.FoldingDescriptor
import com.intellij.openapi.editor.Document
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiElement
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
    override fun visitRecordBody(o: PyPasRecordBody) {
        val currentRange = o.textRange
        val definitionsRange = o.varDefinitions.textRange
        val range = TextRange(currentRange.startOffset, definitionsRange.endOffset)
        descriptors += FoldingDescriptor(o.node, range)
        super.visitRecordBody(o)
    }

    override fun visitBlockStatementsBody(o: PyPasBlockStatementsBody) {
        val currentRange = o.textRange
        val statementsRange = o.statements?.textRange
        if (statementsRange != null) {
            val range = TextRange(currentRange.startOffset, statementsRange.endOffset)
            descriptors += FoldingDescriptor(o.node, range)
        }
        super.visitBlockStatementsBody(o)
    }
}