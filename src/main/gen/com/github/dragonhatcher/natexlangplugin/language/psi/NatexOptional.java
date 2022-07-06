// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NatexOptional extends PsiElement {

  @Nullable
  NatexAssignment getAssignment();

  @Nullable
  NatexConjunction getConjunction();

  @Nullable
  NatexDisjunction getDisjunction();

  @Nullable
  NatexMacro getMacro();

  @Nullable
  NatexNegation getNegation();

  @Nullable
  NatexSequence getSequence();

}
