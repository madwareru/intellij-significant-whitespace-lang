package com.github.madwareru.intellijsignificantwhitespacelang.language

import com.intellij.lang.Language

class PyPasLanguage private constructor() : Language("PyPas") {
    companion object {
        @JvmStatic
        val INSTANCE = PyPasLanguage()
    }
}