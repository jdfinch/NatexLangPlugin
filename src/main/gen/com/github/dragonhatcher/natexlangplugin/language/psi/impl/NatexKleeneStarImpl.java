// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.dragonhatcher.natexlangplugin.language.psi.*;

public class NatexKleeneStarImpl extends ASTWrapperPsiElement implements NatexKleeneStar {

  public NatexKleeneStarImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitKleeneStar(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NatexAssignment getAssignment() {
    return findChildByClass(NatexAssignment.class);
  }

  @Override
  @Nullable
  public NatexConjunction getConjunction() {
    return findChildByClass(NatexConjunction.class);
  }

  @Override
  @Nullable
  public NatexDisjunction getDisjunction() {
    return findChildByClass(NatexDisjunction.class);
  }

  @Override
  @Nullable
  public NatexFlexibleSequence getFlexibleSequence() {
    return findChildByClass(NatexFlexibleSequence.class);
  }

  @Override
  @Nullable
  public NatexMacro getMacro() {
    return findChildByClass(NatexMacro.class);
  }

  @Override
  @Nullable
  public NatexNegation getNegation() {
    return findChildByClass(NatexNegation.class);
  }

  @Override
  @Nullable
  public NatexRigidSequence getRigidSequence() {
    return findChildByClass(NatexRigidSequence.class);
  }

}
