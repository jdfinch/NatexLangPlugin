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
  // L_ARROW multi_term R_ARROW
  public static boolean conjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction")) return false;
    if (!nextTokenIs(b, L_ARROW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_ARROW);
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, R_ARROW);
    exit_section_(b, m, CONJUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY multi_term R_CURLY
  public static boolean disjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, DISJUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // L_BRACKET multi_term R_BRACKET
  public static boolean flexible_sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "flexible_sequence")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, FLEXIBLE_SEQUENCE, r);
    return r;
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
  // "#" SYMBOL ( L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN )?
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

  // ( L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN )?
  private static boolean macro_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2")) return false;
    macro_2_0(b, l + 1);
    return true;
  }

  // L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN
  private static boolean macro_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && macro_2_0_1(b, l + 1);
    r = r && macro_2_0_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
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
  // term (","? term)*
  public static boolean multi_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTI_TERM, "<multi term>");
    r = term(b, l + 1);
    r = r && multi_term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (","? term)*
  private static boolean multi_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multi_term_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multi_term_1", c)) break;
    }
    return true;
  }

  // ","? term
  private static boolean multi_term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multi_term_1_0_0(b, l + 1);
    r = r && term(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean multi_term_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  /* ********************************************************** */
  // system_obj | user_obj
  static boolean natexFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "natexFile")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    r = system_obj(b, l + 1);
    if (!r) r = user_obj(b, l + 1);
    return r;
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
  // flexible_sequence | rigid_sequence | conjunction | disjunction | negation | REGEX | reference | assignment | macro | LITERAL | SYMBOL | STATE | KEYWORD
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
    if (!r) r = consumeToken(b, STATE);
    if (!r) r = consumeToken(b, KEYWORD);
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
  // L_BRACKET "!" multi_term R_BRACKET
  public static boolean rigid_sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "rigid_sequence")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_BRACKET);
    r = r && consumeToken(b, "!");
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, R_BRACKET);
    exit_section_(b, m, RIGID_SEQUENCE, r);
    return r;
  }

  /* ********************************************************** */
  // SYMBOL
  public static boolean state_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "state_name")) return false;
    if (!nextTokenIs(b, SYMBOL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SYMBOL);
    exit_section_(b, m, STATE_NAME, r);
    return r;
  }

  /* ********************************************************** */
  // QUOTE "state" QUOTE ":" QUOTE state_name QUOTE |
  //               QUOTE "score" QUOTE ":" |
  //               QUOTE "speaker" QUOTE ":" QUOTE "system" QUOTE |
  //               QUOTE multi_term QUOTE ":" (QUOTE state_name QUOTE | user_obj | system_obj)
  public static boolean system_kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = system_kv_0(b, l + 1);
    if (!r) r = system_kv_1(b, l + 1);
    if (!r) r = system_kv_2(b, l + 1);
    if (!r) r = system_kv_3(b, l + 1);
    exit_section_(b, m, SYSTEM_KV, r);
    return r;
  }

  // QUOTE "state" QUOTE ":" QUOTE state_name QUOTE
  private static boolean system_kv_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "state");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, QUOTE);
    r = r && state_name(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE "score" QUOTE ":"
  private static boolean system_kv_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "score");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE "speaker" QUOTE ":" QUOTE "system" QUOTE
  private static boolean system_kv_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "speaker");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, "system");
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE multi_term QUOTE ":" (QUOTE state_name QUOTE | user_obj | system_obj)
  private static boolean system_kv_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && system_kv_3_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE state_name QUOTE | user_obj | system_obj
  private static boolean system_kv_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_3_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = system_kv_3_4_0(b, l + 1);
    if (!r) r = user_obj(b, l + 1);
    if (!r) r = system_obj(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE state_name QUOTE
  private static boolean system_kv_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_kv_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && state_name(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY system_kv ("," system_kv)* ","? R_CURLY
  public static boolean system_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_obj")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && system_kv(b, l + 1);
    r = r && system_obj_2(b, l + 1);
    r = r && system_obj_3(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, SYSTEM_OBJ, r);
    return r;
  }

  // ("," system_kv)*
  private static boolean system_obj_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_obj_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!system_obj_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "system_obj_2", c)) break;
    }
    return true;
  }

  // "," system_kv
  private static boolean system_obj_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_obj_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && system_kv(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean system_obj_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "system_obj_3")) return false;
    consumeToken(b, ",");
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
  // QUOTE "state" QUOTE ":" QUOTE state_name QUOTE |
  //             QUOTE "score" QUOTE ":" |
  //             QUOTE "speaker" QUOTE ":" QUOTE "user" QUOTE |
  //             QUOTE multi_term QUOTE ":" (QUOTE state_name QUOTE | system_obj | user_obj)
  public static boolean user_kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = user_kv_0(b, l + 1);
    if (!r) r = user_kv_1(b, l + 1);
    if (!r) r = user_kv_2(b, l + 1);
    if (!r) r = user_kv_3(b, l + 1);
    exit_section_(b, m, USER_KV, r);
    return r;
  }

  // QUOTE "state" QUOTE ":" QUOTE state_name QUOTE
  private static boolean user_kv_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "state");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, QUOTE);
    r = r && state_name(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE "score" QUOTE ":"
  private static boolean user_kv_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "score");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE "speaker" QUOTE ":" QUOTE "user" QUOTE
  private static boolean user_kv_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "speaker");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, "user");
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE multi_term QUOTE ":" (QUOTE state_name QUOTE | system_obj | user_obj)
  private static boolean user_kv_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && multi_term(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    r = r && consumeToken(b, ":");
    r = r && user_kv_3_4(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE state_name QUOTE | system_obj | user_obj
  private static boolean user_kv_3_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_3_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = user_kv_3_4_0(b, l + 1);
    if (!r) r = system_obj(b, l + 1);
    if (!r) r = user_obj(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUOTE state_name QUOTE
  private static boolean user_kv_3_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_kv_3_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUOTE);
    r = r && state_name(b, l + 1);
    r = r && consumeToken(b, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY user_kv ("," user_kv)* ","? R_CURLY
  public static boolean user_obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_obj")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && user_kv(b, l + 1);
    r = r && user_obj_2(b, l + 1);
    r = r && user_obj_3(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, USER_OBJ, r);
    return r;
  }

  // ("," user_kv)*
  private static boolean user_obj_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_obj_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!user_obj_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "user_obj_2", c)) break;
    }
    return true;
  }

  // "," user_kv
  private static boolean user_obj_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_obj_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && user_kv(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean user_obj_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_obj_3")) return false;
    consumeToken(b, ",");
    return true;
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
