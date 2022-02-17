package com.github.madwareru.intellijsignificantwhitespacelang.language
import com.intellij.psi.tree.IElementType

class PyPasLexerWrapper : PyPasLexer() {
    override fun advance(): IElementType? {
        val nextToken = super.advance()
        return when {
            nextToken != null -> nextToken
            stillHasWorkToDo() -> drainIndentStack()
            else -> null
        }
    }
}