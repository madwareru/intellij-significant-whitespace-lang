package com.github.madwareru.intellijsignificantwhitespacelang.ide.braces

import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PY_PAS_COMMENTS
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.tokenSetOf
import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class PyPasPairedBraceMatcher : PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = PAIRS

    override fun isPairedBracesAllowedBeforeType(lbraceType: IElementType, next: IElementType?): Boolean =
        next in InsertPairBraceBefore

    override fun getCodeConstructStart(file: PsiFile?, openingBraceOffset: Int): Int = openingBraceOffset

    companion object {
        private val PAIRS = arrayOf(
            BracePair(PyPasTypes.BRACKETL, PyPasTypes.BRACKETR, true),
            BracePair(PyPasTypes.PARENTHESISL, PyPasTypes.PARENTHESISR, true)
        )

        private val InsertPairBraceBefore = TokenSet.orSet(
            PY_PAS_COMMENTS,
            tokenSetOf(
                PyPasTypes.COMMA,
                PyPasTypes.PARENTHESISR,
                PyPasTypes.BRACKETR,
            )
        )
    }
}