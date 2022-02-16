// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.*;

public class PyPasDefinitionImpl extends ASTWrapperPsiElement implements PyPasDefinition {

  public PyPasDefinitionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PyPasVisitor visitor) {
    visitor.visitDefinition(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PyPasVisitor) accept((PyPasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PyPasFuncDefine getFuncDefine() {
    return findChildByClass(PyPasFuncDefine.class);
  }

  @Override
  @Nullable
  public PyPasProcDefine getProcDefine() {
    return findChildByClass(PyPasProcDefine.class);
  }

  @Override
  @Nullable
  public PyPasRecordDefine getRecordDefine() {
    return findChildByClass(PyPasRecordDefine.class);
  }

}
