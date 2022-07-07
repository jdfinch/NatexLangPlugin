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

public class NatexKvImpl extends ASTWrapperPsiElement implements NatexKv {

  public NatexKvImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitKv(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NatexScore getScore() {
    return findChildByClass(NatexScore.class);
  }

  @Override
  @Nullable
  public NatexSpeaker getSpeaker() {
    return findChildByClass(NatexSpeaker.class);
  }

  @Override
  @Nullable
  public NatexStateDeclaration getStateDeclaration() {
    return findChildByClass(NatexStateDeclaration.class);
  }

  @Override
  @Nullable
  public NatexTermKv getTermKv() {
    return findChildByClass(NatexTermKv.class);
  }

}
