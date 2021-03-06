// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface PyPasSingleLineStatement extends PsiElement {

  @Nullable
  PyPasAssignmentStatement getAssignmentStatement();

  @Nullable
  PyPasFunctionInvocation getFunctionInvocation();

  @Nullable
  PyPasLetStatementSingleLine getLetStatementSingleLine();

  @Nullable
  PyPasReturnStatement getReturnStatement();

  @Nullable
  PyPasVarStatementSingleLine getVarStatementSingleLine();

}
