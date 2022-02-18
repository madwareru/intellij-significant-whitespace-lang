package com.github.madwareru.intellijsignificantwhitespacelang.ide.colors

import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasElementFactory
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes
import com.github.madwareru.intellijsignificantwhitespacelang.util.isElementOfType
import com.intellij.codeInsight.daemon.GutterIconNavigationHandler
import com.intellij.codeInsight.daemon.LineMarkerInfo
import com.intellij.codeInsight.daemon.LineMarkerProvider
import com.intellij.codeInsight.daemon.MergeableLineMarkerInfo
import com.intellij.ide.IdeBundle
import com.intellij.openapi.application.WriteAction
import com.intellij.openapi.command.CommandProcessor
import com.intellij.openapi.editor.markup.GutterIconRenderer
import com.intellij.openapi.editor.markup.HighlighterTargetArea
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiElement
import com.intellij.psi.util.PsiEditorUtil
import com.intellij.refactoring.suggested.endOffset
import com.intellij.refactoring.suggested.startOffset
import com.intellij.ui.ColorChooser
import com.intellij.ui.scale.JBUIScale
import com.intellij.util.Function
import com.intellij.util.FunctionUtil
import com.intellij.util.ui.ColorIcon
import com.intellij.util.ui.ColorsIcon
import java.awt.Color
import java.awt.event.MouseEvent
import javax.swing.Icon

class PyPasColoredConstantsProvider : LineMarkerProvider {
    override fun getLineMarkerInfo(element: PsiElement): LineMarkerInfo<*>? {
        val color = when {
            element.isElementOfType(PyPasTypes.INTEGER) -> {
                val elementText = element.text
                val colorRegex = Regex("0x[0-9a-fA-F]{1,6}")
                if (colorRegex.matches(elementText)) {
                    Color.decode(elementText)
                } else {
                    null
                }
            }
            else -> null
        }
        return if (color != null) { MyInfo(element, color) } else { null }
    }

    private class MyInfo constructor(element: PsiElement, private val myColor: Color) :
        MergeableLineMarkerInfo<PsiElement?>(
            element,
            element.textRange,
            JBUIScale.scaleIcon(ColorIcon(12, myColor)),
            FunctionUtil.nullConstant<Any, String>(),
            GutterIconNavigationHandler { _: MouseEvent, e: PsiElement? ->
                if (e?.isWritable == true) {
                    val editor = PsiEditorUtil.findEditor(e)
                    if (editor != null) {
                        val color = ColorChooser.chooseColor(
                            e.project,
                            editor.component,
                            IdeBundle.message("dialog.title.choose.color"),
                            myColor
                        )
                        if (color != null) {
                            val document = PsiDocumentManager.getInstance(e.project).getDocument(e.containingFile)
                            val command = Runnable {
                                WriteAction.run<RuntimeException> {
                                    val colorNumberText = (color.red * 0x10000 + color.green * 0x100 + color.blue).toString(16)
                                    val newElement = PyPasElementFactory.createConstantLiteral(e.project, "0x$colorNumberText")
                                    element.parent.replace(newElement)
                                }
                            }
                            CommandProcessor.getInstance().executeCommand(
                                e.project,
                                command,
                                "Change Color",
                                null, // groupId
                                document,
                            )
                        }
                    }
                }
            },
            GutterIconRenderer.Alignment.LEFT,
            { "ColoredConstantIcons" }
        ) {

        override fun canMergeWith(info: MergeableLineMarkerInfo<*>): Boolean = info is MyInfo

        override fun getCommonIcon(infos: List<MergeableLineMarkerInfo<*>?>): Icon {
            val iconsArray: Array<Color> = infos
                .map { _info: MergeableLineMarkerInfo<*>? -> (_info as MyInfo?)!!.myColor!! }
                .toTypedArray()

            return when(iconsArray.size) {
                1 -> JBUIScale.scaleIcon(ColorsIcon(12, iconsArray[0]))
                2 -> JBUIScale.scaleIcon(ColorsIcon(12, iconsArray[0], iconsArray[1]))
                3 -> JBUIScale.scaleIcon(ColorsIcon(12, iconsArray[0], iconsArray[1], iconsArray[2]))
                4 -> JBUIScale.scaleIcon(ColorsIcon(12, iconsArray[0], iconsArray[1], iconsArray[2], iconsArray[3]))
                else -> JBUIScale.scaleIcon(ColorsIcon(12, iconsArray[0], iconsArray[1], iconsArray[2], iconsArray[3], iconsArray[4]))
            }
        }

        override fun getCommonTooltip(infos: List<MergeableLineMarkerInfo<*>?>): Function<in PsiElement, String> =
            FunctionUtil.nullConstant()
    }
}