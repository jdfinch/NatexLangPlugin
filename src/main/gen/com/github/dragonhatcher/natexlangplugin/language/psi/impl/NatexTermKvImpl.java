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

public class NatexTermKvImpl extends ASTWrapperPsiElement implements NatexTermKv {

  public NatexTermKvImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitTermKv(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public NatexMultiTerm getMultiTerm() {
    return findNotNullChildByClass(NatexMultiTerm.class);
  }

  @Override
  @Nullable
  public NatexObj getObj() {
    return findChildByClass(NatexObj.class);
  }

  @Override
  @Nullable
  public NatexStateRef getStateRef() {
    return findChildByClass(NatexStateRef.class);
  }

}
