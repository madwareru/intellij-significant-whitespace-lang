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

public class PyPasIfStatementImpl extends ASTWrapperPsiElement implements PyPasIfStatement {

  public PyPasIfStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PyPasVisitor visitor) {
    visitor.visitIfStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PyPasVisitor) accept((PyPasVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<PyPasBlockStatementsBody> getBlockStatementsBodyList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PyPasBlockStatementsBody.class);
  }

  @Override
  @NotNull
  public List<PyPasOperatorExpr> getOperatorExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, PyPasOperatorExpr.class);
  }

}
