// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NatexStateDeclaration extends NatexNamedElement {

  @Nullable
  NatexStateName getStateName();

  String getName();

  PsiElement setName(String newName);

  PsiElement getNameIdentifier();

  int getTextOffset();

}
