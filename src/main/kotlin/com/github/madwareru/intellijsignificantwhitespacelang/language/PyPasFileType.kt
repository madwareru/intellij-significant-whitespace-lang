package com.github.madwareru.intellijsignificantwhitespacelang.language

import com.github.madwareru.intellijsignificantwhitespacelang.ide.icons.PyPasIcons
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

class PyPasFileType private constructor() : LanguageFileType(PyPasLanguage.INSTANCE) {
    override fun getName(): String = "PyPas file"
    override fun getDescription(): String = "Python flavoured toy pascal file"
    override fun getDefaultExtension(): String = "pypas"
    override fun getIcon(): Icon? = PyPasIcons.FILE
    companion object {
        @JvmStatic
        val INSTANCE = PyPasFileType()
    }
}