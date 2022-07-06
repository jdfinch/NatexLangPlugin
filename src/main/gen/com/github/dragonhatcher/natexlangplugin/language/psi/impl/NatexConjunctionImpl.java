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

public class NatexConjunctionImpl extends ASTWrapperPsiElement implements NatexConjunction {

  public NatexConjunctionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitConjunction(this);
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

}
