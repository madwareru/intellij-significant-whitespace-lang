package com.github.madwareru.intellijsignificantwhitespacelang.language.psi

import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasFileType
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiFileFactory
import com.intellij.psi.util.descendantsOfType

object PyPasElementFactory {
    fun createConstantLiteral(project: Project, constantLiteralText: String): PyPasConstantLiteral {
        val file = createFile(project, text = "mod dummy:\n    proc FooBar():\n        let color: i32 := ${constantLiteralText}\n")
        return (file.firstChild.nextSibling as PyPasDefinitions).descendantsOfType<PyPasConstantLiteral>().single()
    }

    private fun createFile(project: Project, text: String): PyPasFile {
        val name = "temp.pypas"
        return PsiFileFactory.getInstance(project).createFileFromText(name, PyPasFileType.INSTANCE, text) as PyPasFile
    }
}