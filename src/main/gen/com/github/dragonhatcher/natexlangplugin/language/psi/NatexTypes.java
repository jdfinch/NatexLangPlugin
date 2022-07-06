// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.dragonhatcher.natexlangplugin.language.psi.impl.*;

public interface NatexTypes {

  IElementType ASSIGNMENT = new NatexElementType("ASSIGNMENT");
  IElementType CONJUNCTION = new NatexElementType("CONJUNCTION");
  IElementType DISJUNCTION = new NatexElementType("DISJUNCTION");
  IElementType FLEXIBLE_SEQUENCE = new NatexElementType("FLEXIBLE_SEQUENCE");
  IElementType KLEENE_PLUS = new NatexElementType("KLEENE_PLUS");
  IElementType KLEENE_STAR = new NatexElementType("KLEENE_STAR");
  IElementType MACRO = new NatexElementType("MACRO");
  IElementType MACRO_ARG = new NatexElementType("MACRO_ARG");
  IElementType NEGATION = new NatexElementType("NEGATION");
  IElementType OPTIONAL = new NatexElementType("OPTIONAL");
  IElementType REFERENCE = new NatexElementType("REFERENCE");
  IElementType RIGID_SEQUENCE = new NatexElementType("RIGID_SEQUENCE");
  IElementType X = new NatexElementType("X");

  IElementType LITERAL = new NatexTokenType("LITERAL");
  IElementType MACRO_ARG_STRING = new NatexTokenType("MACRO_ARG_STRING");
  IElementType MACRO_LITERAL = new NatexTokenType("MACRO_LITERAL");
  IElementType PUNCUATION = new NatexTokenType("PUNCUATION");
  IElementType REGEX = new NatexTokenType("REGEX");
  IElementType SYMBOL = new NatexTokenType("SYMBOL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ASSIGNMENT) {
        return new NatexAssignmentImpl(node);
      }
      else if (type == CONJUNCTION) {
        return new NatexConjunctionImpl(node);
      }
      else if (type == DISJUNCTION) {
        return new NatexDisjunctionImpl(node);
      }
      else if (type == FLEXIBLE_SEQUENCE) {
        return new NatexFlexibleSequenceImpl(node);
      }
      else if (type == KLEENE_PLUS) {
        return new NatexKleenePlusImpl(node);
      }
      else if (type == KLEENE_STAR) {
        return new NatexKleeneStarImpl(node);
      }
      else if (type == MACRO) {
        return new NatexMacroImpl(node);
      }
      else if (type == MACRO_ARG) {
        return new NatexMacroArgImpl(node);
      }
      else if (type == NEGATION) {
        return new NatexNegationImpl(node);
      }
      else if (type == OPTIONAL) {
        return new NatexOptionalImpl(node);
      }
      else if (type == REFERENCE) {
        return new NatexReferenceImpl(node);
      }
      else if (type == RIGID_SEQUENCE) {
        return new NatexRigidSequenceImpl(node);
      }
      else if (type == X) {
        return new NatexXImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
