// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface NatexRigidSequence extends PsiElement {

  @NotNull
  List<NatexAssignment> getAssignmentList();

  @NotNull
  List<NatexConjunction> getConjunctionList();

  @NotNull
  List<NatexDisjunction> getDisjunctionList();

  @NotNull
  List<NatexFlexibleSequence> getFlexibleSequenceList();

  @NotNull
  List<NatexKleenePlus> getKleenePlusList();

  @NotNull
  List<NatexKleeneStar> getKleeneStarList();

  @NotNull
  List<NatexMacro> getMacroList();

  @NotNull
  List<NatexNegation> getNegationList();

  @NotNull
  List<NatexOptional> getOptionalList();

  @NotNull
  List<NatexReference> getReferenceList();

  @NotNull
  List<NatexRigidSequence> getRigidSequenceList();

}
