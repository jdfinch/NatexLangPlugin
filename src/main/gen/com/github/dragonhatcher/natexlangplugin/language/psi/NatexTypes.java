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
  IElementType KLEENE_PLUS = new NatexElementType("KLEENE_PLUS");
  IElementType KLEENE_STAR = new NatexElementType("KLEENE_STAR");
  IElementType KV = new NatexElementType("KV");
  IElementType MACRO = new NatexElementType("MACRO");
  IElementType MACRO_ARG = new NatexElementType("MACRO_ARG");
  IElementType MULTI_TERM = new NatexElementType("MULTI_TERM");
  IElementType NEGATION = new NatexElementType("NEGATION");
  IElementType OBJ = new NatexElementType("OBJ");
  IElementType OPTIONAL = new NatexElementType("OPTIONAL");
  IElementType SCORE = new NatexElementType("SCORE");
  IElementType SEQUENCE = new NatexElementType("SEQUENCE");
  IElementType SPEAKER = new NatexElementType("SPEAKER");
  IElementType STATE_DECLARATION = new NatexElementType("STATE_DECLARATION");
  IElementType STATE_NAME = new NatexElementType("STATE_NAME");
  IElementType STATE_REF = new NatexElementType("STATE_REF");
  IElementType TERM = new NatexElementType("TERM");
  IElementType TERM_KV = new NatexElementType("TERM_KV");
  IElementType VAR_REFERENCE = new NatexElementType("VAR_REFERENCE");
  IElementType X = new NatexElementType("X");

  IElementType KEYWORD = new NatexTokenType("KEYWORD");
  IElementType LITERAL = new NatexTokenType("LITERAL");
  IElementType L_ARROW = new NatexTokenType("L_ARROW");
  IElementType L_BRACKET = new NatexTokenType("L_BRACKET");
  IElementType L_CURLY = new NatexTokenType("L_CURLY");
  IElementType L_PAREN = new NatexTokenType("L_PAREN");
  IElementType MACRO_ARG_STRING = new NatexTokenType("MACRO_ARG_STRING");
  IElementType MACRO_LITERAL = new NatexTokenType("MACRO_LITERAL");
  IElementType MACRO_NAME = new NatexTokenType("MACRO_NAME");
  IElementType PUNCUATION = new NatexTokenType("PUNCUATION");
  IElementType QUOTE = new NatexTokenType("QUOTE");
  IElementType REGEX = new NatexTokenType("REGEX");
  IElementType R_ARROW = new NatexTokenType("R_ARROW");
  IElementType R_BRACKET = new NatexTokenType("R_BRACKET");
  IElementType R_CURLY = new NatexTokenType("R_CURLY");
  IElementType R_PAREN = new NatexTokenType("R_PAREN");
  IElementType STATE = new NatexTokenType("STATE");
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
      else if (type == KLEENE_PLUS) {
        return new NatexKleenePlusImpl(node);
      }
      else if (type == KLEENE_STAR) {
        return new NatexKleeneStarImpl(node);
      }
      else if (type == KV) {
        return new NatexKvImpl(node);
      }
      else if (type == MACRO) {
        return new NatexMacroImpl(node);
      }
      else if (type == MACRO_ARG) {
        return new NatexMacroArgImpl(node);
      }
      else if (type == MULTI_TERM) {
        return new NatexMultiTermImpl(node);
      }
      else if (type == NEGATION) {
        return new NatexNegationImpl(node);
      }
      else if (type == OBJ) {
        return new NatexObjImpl(node);
      }
      else if (type == OPTIONAL) {
        return new NatexOptionalImpl(node);
      }
      else if (type == SCORE) {
        return new NatexScoreImpl(node);
      }
      else if (type == SEQUENCE) {
        return new NatexSequenceImpl(node);
      }
      else if (type == SPEAKER) {
        return new NatexSpeakerImpl(node);
      }
      else if (type == STATE_DECLARATION) {
        return new NatexStateDeclarationImpl(node);
      }
      else if (type == STATE_NAME) {
        return new NatexStateNameImpl(node);
      }
      else if (type == STATE_REF) {
        return new NatexStateRefImpl(node);
      }
      else if (type == TERM) {
        return new NatexTermImpl(node);
      }
      else if (type == TERM_KV) {
        return new NatexTermKvImpl(node);
      }
      else if (type == VAR_REFERENCE) {
        return new NatexVarReferenceImpl(node);
      }
      else if (type == X) {
        return new NatexXImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
