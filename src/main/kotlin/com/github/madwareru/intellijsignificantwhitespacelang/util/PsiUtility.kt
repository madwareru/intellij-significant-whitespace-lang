package com.github.madwareru.intellijsignificantwhitespacelang.util

import com.intellij.psi.PsiElement
import com.intellij.psi.tree.IElementType
import com.intellij.psi.util.elementType

fun PsiElement.scrollLeft(): PsiElement? = this.prevSibling ?: this.parent

fun PsiElement.isElementOfType(test: IElementType): Boolean = this.elementType?.equals(test) ?: false