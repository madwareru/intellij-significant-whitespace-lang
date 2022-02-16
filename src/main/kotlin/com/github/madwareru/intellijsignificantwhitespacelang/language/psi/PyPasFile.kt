package com.github.madwareru.intellijsignificantwhitespacelang.language.psi

import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasFileType
import com.github.madwareru.intellijsignificantwhitespacelang.language.PyPasLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class PyPasFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, PyPasLanguage.INSTANCE) {
    override fun getFileType(): FileType = PyPasFileType.INSTANCE
    override fun toString(): String = "PyPas file"
}

//open class PyPasRecursiveVisitor : PyPasVisitor(), PsiRecursiveVisitor {
//    override fun visitElement(element: PsiElement) {
//        ProgressManager.checkCanceled()
//        element.acceptChildren(this)
//    }
//}
