package com.github.madwareru.intellijsignificantwhitespacelang.ide

import com.github.madwareru.intellijsignificantwhitespacelang.ide.colors.PyPasColors
import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasLexerAdapter
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

class PyPasSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return PyPasLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return pack(getTokenColor(tokenType).textAttributesKey)
    }

    private fun getTokenColor(tokenType: IElementType?): PyPasColors {
        return when (tokenType) {
            PyPasTypes.COLON -> PyPasColors.COLON
            PyPasTypes.COMMA -> PyPasColors.COMMA
            PyPasTypes.IDENT -> PyPasColors.IDENTIFIER
            TokenType.BAD_CHARACTER -> PyPasColors.BAD_CHAR
            else -> getTokenColorSpecial(tokenType)
        }
    }

    private fun getTokenColorSpecial(tokenType: IElementType?): PyPasColors {
        return when (tokenType) {
            PyPasTypes.PARENTHESISL, PyPasTypes.PARENTHESISR -> PyPasColors.PARENTHESES
            PyPasTypes.BRACKETL, PyPasTypes.BRACKETR -> PyPasColors.BRACKETS
            PyPasTypes.INTEGER, PyPasTypes.FLOAT, PyPasTypes.BOOLEAN -> PyPasColors.NUMBER
            PyPasTypes.STRING, PyPasTypes.CHAR -> PyPasColors.STRING
            PyPasTypes.COMMENT -> PyPasColors.COMMENT
            else -> PyPasColors.OTHER
        }
    }
}