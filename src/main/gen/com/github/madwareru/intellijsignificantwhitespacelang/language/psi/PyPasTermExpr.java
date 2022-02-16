// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PyPasTermExpr extends PsiElement {

  @Nullable
  PyPasConstantLiteral getConstantLiteral();

  @Nullable
  PyPasFunctionInvocation getFunctionInvocation();

  @Nullable
  PyPasIndexedAccess getIndexedAccess();

  @Nullable
  PyPasLogicAndExpr getLogicAndExpr();

  @Nullable
  PyPasSubfieldAccess getSubfieldAccess();

  @Nullable
  PyPasVariableAccess getVariableAccess();

}
