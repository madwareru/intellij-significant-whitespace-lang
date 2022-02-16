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

public class PyPasTermExprImpl extends ASTWrapperPsiElement implements PyPasTermExpr {

  public PyPasTermExprImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PyPasVisitor visitor) {
    visitor.visitTermExpr(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PyPasVisitor) accept((PyPasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public PyPasConstantLiteral getConstantLiteral() {
    return findChildByClass(PyPasConstantLiteral.class);
  }

  @Override
  @Nullable
  public PyPasFunctionInvocation getFunctionInvocation() {
    return findChildByClass(PyPasFunctionInvocation.class);
  }

  @Override
  @Nullable
  public PyPasIndexedAccess getIndexedAccess() {
    return findChildByClass(PyPasIndexedAccess.class);
  }

  @Override
  @Nullable
  public PyPasLogicAndExpr getLogicAndExpr() {
    return findChildByClass(PyPasLogicAndExpr.class);
  }

  @Override
  @Nullable
  public PyPasSubfieldAccess getSubfieldAccess() {
    return findChildByClass(PyPasSubfieldAccess.class);
  }

  @Override
  @Nullable
  public PyPasVariableAccess getVariableAccess() {
    return findChildByClass(PyPasVariableAccess.class);
  }

}
