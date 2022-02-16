package com.github.madwareru.intellijsignificantwhitespacelang.language.psi

import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasLanguage
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes.COMMENT

class PyPasTokenType(debugName: String) : IElementType(debugName, PyPasLanguage.INSTANCE) {
    override fun toString(): String = "PyPasTokenType.${super.toString()}"
}

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)

val PY_PAS_COMMENTS = tokenSetOf(COMMENT)