// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class NatexParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return natexFile(b, l + 1);
  }

  /* ********************************************************** */
  // "$" SYMBOL "=" term
  public static boolean assignment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = consumeToken(b, "$");
    r = r && consumeToken(b, SYMBOL);
    r = r && consumeToken(b, "=");
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "<" term (","? " "? term)* ">"
  public static boolean conjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONJUNCTION, "<conjunction>");
    r = consumeToken(b, "<");
    r = r && term(b, l + 1);
    r = r && conjunction_2(b, l + 1);
    r = r && consumeToken(b, ">");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (","? " "? term)*
  private static boolean conjunction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!conjunction_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "conjunction_2", c)) break;
    }
    return true;
  }

  // ","? " "? term
  private static boolean conjunction_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = conjunction_2_0_0(b, l + 1);
    r = r && conjunction_2_0_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean conjunction_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction_2_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean conjunction_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction_2_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // "{" term (","? " "? term)* "}"
  public static boolean disjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DISJUNCTION, "<disjunction>");
    r = consumeToken(b, "{");
    r = r && term(b, l + 1);
    r = r && disjunction_2(b, l + 1);
    r = r && consumeToken(b, "}");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (","? " "? term)*
  private static boolean disjunction_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!disjunction_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "disjunction_2", c)) break;
    }
    return true;
  }

  // ","? " "? term
  private static boolean disjunction_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = disjunction_2_0_0(b, l + 1);
    r = r && disjunction_2_0_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean disjunction_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction_2_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean disjunction_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction_2_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // "[" " "? term (","? " "? term)* "]"
  public static boolean flexible_sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLEXIBLE_SEQUENCE, "<flexible sequence>");
    r = consumeToken(b, "[");
    r = r && flexible_sequence_1(b, l + 1);
    r = r && term(b, l + 1);
    r = r && flexible_sequence_3(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // " "?
  private static boolean flexible_sequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  // (","? " "? term)*
  private static boolean flexible_sequence_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!flexible_sequence_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "flexible_sequence_3", c)) break;
    }
    return true;
  }

  // ","? " "? term
  private static boolean flexible_sequence_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = flexible_sequence_3_0_0(b, l + 1);
    r = r && flexible_sequence_3_0_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean flexible_sequence_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence_3_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean flexible_sequence_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence_3_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // non_kleene_term "+"
  public static boolean kleene_plus(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kleene_plus")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KLEENE_PLUS, "<kleene plus>");
    r = non_kleene_term(b, l + 1);
    r = r && consumeToken(b, "+");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // non_kleene_term "*"
  public static boolean kleene_star(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kleene_star")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KLEENE_STAR, "<kleene star>");
    r = non_kleene_term(b, l + 1);
    r = r && consumeToken(b, "*");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "#" SYMBOL ( "(" macro_arg? (","? " "? macro_arg)* ")" )?
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO, "<macro>");
    r = consumeToken(b, "#");
    r = r && consumeToken(b, SYMBOL);
    r = r && macro_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( "(" macro_arg? (","? " "? macro_arg)* ")" )?
  private static boolean macro_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2")) return false;
    macro_2_0(b, l + 1);
    return true;
  }

  // "(" macro_arg? (","? " "? macro_arg)* ")"
  private static boolean macro_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "(");
    r = r && macro_2_0_1(b, l + 1);
    r = r && macro_2_0_2(b, l + 1);
    r = r && consumeToken(b, ")");
    exit_section_(b, m, null, r);
    return r;
  }

  // macro_arg?
  private static boolean macro_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0_1")) return false;
    macro_arg(b, l + 1);
    return true;
  }

  // (","? " "? macro_arg)*
  private static boolean macro_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!macro_2_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "macro_2_0_2", c)) break;
    }
    return true;
  }

  // ","? " "? macro_arg
  private static boolean macro_2_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro_2_0_2_0_0(b, l + 1);
    r = r && macro_2_0_2_0_1(b, l + 1);
    r = r && macro_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean macro_2_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0_2_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean macro_2_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0_2_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // MACRO_ARG_STRING | MACRO_LITERAL | macro
  public static boolean macro_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_ARG, "<macro arg>");
    r = consumeToken(b, MACRO_ARG_STRING);
    if (!r) r = consumeToken(b, MACRO_LITERAL);
    if (!r) r = macro(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // term (","? " "? term)*
  static boolean natexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = term(b, l + 1);
    r = r && natexFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (","? " "? term)*
  private static boolean natexFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!natexFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "natexFile_1", c)) break;
    }
    return true;
  }

  // ","? " "? term
  private static boolean natexFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = natexFile_1_0_0(b, l + 1);
    r = r && natexFile_1_0_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean natexFile_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile_1_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean natexFile_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile_1_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // "-" term
  public static boolean negation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "negation")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NEGATION, "<negation>");
    r = consumeToken(b, "-");
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // flexible_sequence | rigid_sequence | conjunction | disjunction | negation | REGEX | reference | assignment | macro | LITERAL | SYMBOL
  static boolean non_kleene_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_kleene_term")) return false;
    boolean r;
    r = flexible_sequence(b, l + 1);
    if (!r) r = rigid_sequence(b, l + 1);
    if (!r) r = conjunction(b, l + 1);
    if (!r) r = disjunction(b, l + 1);
    if (!r) r = negation(b, l + 1);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = reference(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = macro(b, l + 1);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, SYMBOL);
    return r;
  }

  /* ********************************************************** */
  // non_kleene_term "?"
  public static boolean optional(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "optional")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL, "<optional>");
    r = non_kleene_term(b, l + 1);
    r = r && consumeToken(b, "?");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "$" SYMBOL
  public static boolean reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REFERENCE, "<reference>");
    r = consumeToken(b, "$");
    r = r && consumeToken(b, SYMBOL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // "[!" " "? term (","? " "? term)* "]"
  public static boolean rigid_sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RIGID_SEQUENCE, "<rigid sequence>");
    r = consumeToken(b, "[!");
    r = r && rigid_sequence_1(b, l + 1);
    r = r && term(b, l + 1);
    r = r && rigid_sequence_3(b, l + 1);
    r = r && consumeToken(b, "]");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // " "?
  private static boolean rigid_sequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  // (","? " "? term)*
  private static boolean rigid_sequence_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!rigid_sequence_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "rigid_sequence_3", c)) break;
    }
    return true;
  }

  // ","? " "? term
  private static boolean rigid_sequence_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = rigid_sequence_3_0_0(b, l + 1);
    r = r && rigid_sequence_3_0_1(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean rigid_sequence_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence_3_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean rigid_sequence_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence_3_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // optional | kleene_star | kleene_plus | non_kleene_term
  static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    r = optional(b, l + 1);
    if (!r) r = kleene_star(b, l + 1);
    if (!r) r = kleene_plus(b, l + 1);
    if (!r) r = non_kleene_term(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PUNCUATION
  public static boolean x(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "x")) return false;
    if (!nextTokenIs(b, PUNCUATION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PUNCUATION);
    exit_section_(b, m, X, r);
    return r;
  }

}
