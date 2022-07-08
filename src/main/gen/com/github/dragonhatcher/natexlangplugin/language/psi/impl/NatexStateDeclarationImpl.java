// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes.*;
import com.github.dragonhatcher.natexlangplugin.language.psi.*;

public class NatexStateDeclarationImpl extends NatexNamedElementImpl implements NatexStateDeclaration {

  public NatexStateDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitStateDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public NatexStateName getStateName() {
    return findChildByClass(NatexStateName.class);
  }

  @Override
  public String getName() {
    return NatexPsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(String newName) {
    return NatexPsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return NatexPsiImplUtil.getNameIdentifier(this);
  }

}
