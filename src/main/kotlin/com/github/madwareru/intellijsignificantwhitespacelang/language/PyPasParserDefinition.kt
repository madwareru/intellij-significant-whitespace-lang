package com.github.madwareru.intellijsignificantwhitespacelang.language

import com.github.madwareru.intellijsignificantwhitespacelang.language.parser._PyPasParser
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasFile
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class PyPasParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer = PyPasLexerAdapter()

    override fun createParser(project: Project?): PsiParser = _PyPasParser()

    override fun getFileNodeType(): IFileElementType = FILE

    override fun getCommentTokens(): TokenSet = COMMENTS

    override fun getStringLiteralElements(): TokenSet = STRING_LITERALS

    override fun createElement(node: ASTNode?): PsiElement = PyPasTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = PyPasFile(viewProvider)

    override fun spaceExistenceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements =
        ParserDefinition.SpaceRequirements.MAY

    companion object {
        val COMMENTS = TokenSet.create(PyPasTypes.COMMENT)
        val STRING_LITERALS = TokenSet.create(PyPasTypes.STRING)
        val FILE = IFileElementType(PyPasLanguage.INSTANCE)
    }
}