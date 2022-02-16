package com.github.madwareru.intellijsignificantwhitespacelang.ide.braces

import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasFileType
import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasLanguage
import com.intellij.codeInsight.highlighting.PairedBraceMatcherAdapter
import com.intellij.openapi.editor.highlighter.HighlighterIterator
import com.intellij.openapi.fileTypes.FileType

class PyPasPairedBraceMatcherAdapter : PairedBraceMatcherAdapter(PyPasPairedBraceMatcher(), PyPasLanguage.INSTANCE)  {
    override fun isLBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean =
        isBrace(iterator, fileText, fileType, true)

    override fun isRBraceToken(iterator: HighlighterIterator, fileText: CharSequence, fileType: FileType): Boolean =
        isBrace(iterator, fileText, fileType, false)

    private fun isBrace(
        iterator: HighlighterIterator,
        fileText: CharSequence,
        fileType: FileType,
        left: Boolean
    ): Boolean {
        if (fileType != PyPasFileType.INSTANCE) return false
        val pair = findPair(left, iterator, fileText, fileType)
        return pair != null
    }
}