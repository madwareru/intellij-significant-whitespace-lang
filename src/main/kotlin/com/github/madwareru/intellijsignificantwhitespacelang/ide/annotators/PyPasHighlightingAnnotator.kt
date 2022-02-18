package com.github.madwareru.intellijsignificantwhitespacelang.ide.annotators

import com.github.madwareru.intellijsignificantwhitespacelang.ide.colors.PyPasColors
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes
import com.github.madwareru.intellijsignificantwhitespacelang.util.isElementOfType
import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.EffectType
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.psi.PsiElement
import java.awt.Color

class PyPasHighlightingAnnotator : BaseAnnotator() {
    override fun annotateInternal(element: PsiElement, holder: AnnotationHolder) {
        val parent = element.parent
        if (holder.isBatchMode || parent == null) return
        if (element.isElementOfType(PyPasTypes.INTEGER)) {
            val elementText = element.text
            val colorRegex = Regex("0x[0-9a-fA-F]{6}")
            if (colorRegex.matches(elementText)) {
                val attributes = PyPasColors.NUMBER.textAttributesKey.defaultAttributes
                val color = Color.decode(elementText)
                attributes.effectColor = color
                attributes.effectType = EffectType.BOLD_LINE_UNDERSCORE
                holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .enforcedTextAttributes(attributes)
                    .create()
            }
        }
    }
}