// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PyPasStatement extends PsiElement {

  @Nullable
  PyPasForStatement getForStatement();

  @Nullable
  PyPasIfStatement getIfStatement();

  @Nullable
  PyPasLetStatement getLetStatement();

  @NotNull
  List<PyPasSingleLineStatement> getSingleLineStatementList();

  @Nullable
  PyPasVarStatement getVarStatement();

  @Nullable
  PyPasWhileStatement getWhileStatement();

}
