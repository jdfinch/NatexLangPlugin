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

public class NatexMultiTermImpl extends ASTWrapperPsiElement implements NatexMultiTerm {

  public NatexMultiTermImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull NatexVisitor visitor) {
    visitor.visitMultiTerm(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof NatexVisitor) accept((NatexVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<NatexAssignment> getAssignmentList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexAssignment.class);
  }

  @Override
  @NotNull
  public List<NatexConjunction> getConjunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexConjunction.class);
  }

  @Override
  @NotNull
  public List<NatexDisjunction> getDisjunctionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexDisjunction.class);
  }

  @Override
  @NotNull
  public List<NatexFlexibleSequence> getFlexibleSequenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexFlexibleSequence.class);
  }

  @Override
  @NotNull
  public List<NatexKleenePlus> getKleenePlusList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexKleenePlus.class);
  }

  @Override
  @NotNull
  public List<NatexKleeneStar> getKleeneStarList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexKleeneStar.class);
  }

  @Override
  @NotNull
  public List<NatexMacro> getMacroList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexMacro.class);
  }

  @Override
  @NotNull
  public List<NatexNegation> getNegationList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexNegation.class);
  }

  @Override
  @NotNull
  public List<NatexOptional> getOptionalList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexOptional.class);
  }

  @Override
  @NotNull
  public List<NatexReference> getReferenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexReference.class);
  }

  @Override
  @NotNull
  public List<NatexRigidSequence> getRigidSequenceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, NatexRigidSequence.class);
  }

}
