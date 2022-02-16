package com.github.madwareru.intellijsignificantwhitespacelang.ide.annotators

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.psi.PsiElement

class PyPasHighlightingAnnotator : BaseAnnotator() {
    override fun annotateInternal(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (holder.isBatchMode || parent == null) return
        TODO("Not yet implemented")
    }
}