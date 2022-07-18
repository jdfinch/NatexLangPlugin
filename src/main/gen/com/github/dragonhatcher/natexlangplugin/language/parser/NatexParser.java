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
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT, "<assignment>");
    r = consumeToken(b, "$");
    r = r && consumeToken(b, SYMBOL);
    r = r && consumeToken(b, "=");
    p = r; // pin = 3
    r = r && term(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // L_ARROW multi_term R_ARROW
  public static boolean conjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "conjunction")) return false;
    if (!nextTokenIs(b, L_ARROW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, CONJUNCTION, null);
    r = consumeToken(b, L_ARROW);
    p = r; // pin = 1
    r = r && report_error_(b, multi_term(b, l + 1));
    r = p && consumeToken(b, R_ARROW) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // L_CURLY multi_term R_CURLY
  public static boolean disjunction(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "disjunction")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, DISJUNCTION, null);
    r = consumeToken(b, L_CURLY);
    p = r; // pin = 1
    r = r && report_error_(b, multi_term(b, l + 1));
    r = p && consumeToken(b, R_CURLY) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // state_declaration | score | speaker | term_kv
  public static boolean kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "kv")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = state_declaration(b, l + 1);
    if (!r) r = score(b, l + 1);
    if (!r) r = speaker(b, l + 1);
    if (!r) r = term_kv(b, l + 1);
    exit_section_(b, m, KV, r);
    return r;
  }

  /* ********************************************************** */
  // MACRO_NAME ( L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN )?
  public static boolean macro(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro")) return false;
    if (!nextTokenIs(b, MACRO_NAME)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MACRO, null);
    r = consumeToken(b, MACRO_NAME);
    p = r; // pin = 1
    r = r && macro_1(b, l + 1);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN )?
  private static boolean macro_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1")) return false;
    macro_1_0(b, l + 1);
    return true;
  }

  // L_PAREN macro_arg? (","? " "? macro_arg)* R_PAREN
  private static boolean macro_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && macro_1_0_1(b, l + 1);
    r = r && macro_1_0_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // macro_arg?
  private static boolean macro_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0_1")) return false;
    macro_arg(b, l + 1);
    return true;
  }

  // (","? " "? macro_arg)*
  private static boolean macro_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!macro_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "macro_1_0_2", c)) break;
    }
    return true;
  }

  // ","? " "? macro_arg
  private static boolean macro_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro_1_0_2_0_0(b, l + 1);
    r = r && macro_1_0_2_0_1(b, l + 1);
    r = r && macro_arg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean macro_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0_2_0_0")) return false;
    consumeToken(b, ",");
    return true;
  }

  // " "?
  private static boolean macro_1_0_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_1_0_2_0_1")) return false;
    consumeToken(b, " ");
    return true;
  }

  /* ********************************************************** */
  // (MACRO_ARG_STRING | MACRO_LITERAL | SYMBOL | PUNCUATION)+ | macro
  public static boolean macro_arg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_arg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MACRO_ARG, "<macro arg>");
    r = macro_arg_0(b, l + 1);
    if (!r) r = macro(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MACRO_ARG_STRING | MACRO_LITERAL | SYMBOL | PUNCUATION)+
  private static boolean macro_arg_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_arg_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = macro_arg_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!macro_arg_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "macro_arg_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // MACRO_ARG_STRING | MACRO_LITERAL | SYMBOL | PUNCUATION
  private static boolean macro_arg_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "macro_arg_0_0")) return false;
    boolean r;
    r = consumeToken(b, MACRO_ARG_STRING);
    if (!r) r = consumeToken(b, MACRO_LITERAL);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, PUNCUATION);
    return r;
  }

  /* ********************************************************** */
  // term (","? (QUOTE QUOTE)? term)*
  public static boolean multi_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTI_TERM, "<multi term>");
    r = term(b, l + 1);
    r = r && multi_term_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (","? (QUOTE QUOTE)? term)*
  private static boolean multi_term_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multi_term_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multi_term_1", c)) break;
    }
    return true;
  }

  // ","? (QUOTE QUOTE)? term
  private static boolean multi_term_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multi_term_1_0_0(b, l + 1);
    r = r && multi_term_1_0_1(b, l + 1);
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

  // (QUOTE QUOTE)?
  private static boolean multi_term_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1_0_1")) return false;
    multi_term_1_0_1_0(b, l + 1);
    return true;
  }

  // QUOTE QUOTE
  private static boolean multi_term_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multi_term_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, QUOTE, QUOTE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // obj
  static boolean natexFile(PsiBuilder b, int l) {
    return obj(b, l + 1);
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
  // sequence | conjunction | disjunction | negation | REGEX | var_reference | assignment | macro | LITERAL | SYMBOL | STATE | KEYWORD
  static boolean non_kleene_term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "non_kleene_term")) return false;
    boolean r;
    r = sequence(b, l + 1);
    if (!r) r = conjunction(b, l + 1);
    if (!r) r = disjunction(b, l + 1);
    if (!r) r = negation(b, l + 1);
    if (!r) r = consumeToken(b, REGEX);
    if (!r) r = var_reference(b, l + 1);
    if (!r) r = assignment(b, l + 1);
    if (!r) r = macro(b, l + 1);
    if (!r) r = consumeToken(b, LITERAL);
    if (!r) r = consumeToken(b, SYMBOL);
    if (!r) r = consumeToken(b, STATE);
    if (!r) r = consumeToken(b, KEYWORD);
    return r;
  }

  /* ********************************************************** */
  // L_CURLY kv ("," kv)* ","? R_CURLY
  public static boolean obj(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obj")) return false;
    if (!nextTokenIs(b, L_CURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_CURLY);
    r = r && kv(b, l + 1);
    r = r && obj_2(b, l + 1);
    r = r && obj_3(b, l + 1);
    r = r && consumeToken(b, R_CURLY);
    exit_section_(b, m, OBJ, r);
    return r;
  }

  // ("," kv)*
  private static boolean obj_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obj_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!obj_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "obj_2", c)) break;
    }
    return true;
  }

  // "," kv
  private static boolean obj_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obj_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ",");
    r = r && kv(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ","?
  private static boolean obj_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "obj_3")) return false;
    consumeToken(b, ",");
    return true;
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
  // QUOTE "score" QUOTE ":"
  public static boolean score(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "score")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SCORE, null);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "score");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, QUOTE));
    r = p && consumeToken(b, ":") && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // L_BRACKET "!"? multi_term R_BRACKET
  public static boolean sequence(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence")) return false;
    if (!nextTokenIs(b, L_BRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SEQUENCE, null);
    r = consumeToken(b, L_BRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, sequence_1(b, l + 1));
    r = p && report_error_(b, multi_term(b, l + 1)) && r;
    r = p && consumeToken(b, R_BRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // "!"?
  private static boolean sequence_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sequence_1")) return false;
    consumeToken(b, "!");
    return true;
  }

  /* ********************************************************** */
  // QUOTE "speaker" QUOTE ":" QUOTE ("system" | "user") QUOTE
  public static boolean speaker(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "speaker")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, SPEAKER, null);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "speaker");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, QUOTE));
    r = p && report_error_(b, consumeToken(b, ":")) && r;
    r = p && report_error_(b, consumeToken(b, QUOTE)) && r;
    r = p && report_error_(b, speaker_5(b, l + 1)) && r;
    r = p && consumeToken(b, QUOTE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // "system" | "user"
  private static boolean speaker_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "speaker_5")) return false;
    boolean r;
    r = consumeToken(b, "system");
    if (!r) r = consumeToken(b, "user");
    return r;
  }

  /* ********************************************************** */
  // QUOTE "state" QUOTE ":" QUOTE state_name QUOTE
  public static boolean state_declaration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "state_declaration")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATE_DECLARATION, null);
    r = consumeToken(b, QUOTE);
    r = r && consumeToken(b, "state");
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, QUOTE));
    r = p && report_error_(b, consumeToken(b, ":")) && r;
    r = p && report_error_(b, consumeToken(b, QUOTE)) && r;
    r = p && report_error_(b, state_name(b, l + 1)) && r;
    r = p && consumeToken(b, QUOTE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
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
  // QUOTE state_name QUOTE
  public static boolean state_ref(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "state_ref")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STATE_REF, null);
    r = consumeToken(b, QUOTE);
    p = r; // pin = 1
    r = r && report_error_(b, state_name(b, l + 1));
    r = p && consumeToken(b, QUOTE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // optional | kleene_star | kleene_plus | non_kleene_term
  public static boolean term(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM, "<term>");
    r = optional(b, l + 1);
    if (!r) r = kleene_star(b, l + 1);
    if (!r) r = kleene_plus(b, l + 1);
    if (!r) r = non_kleene_term(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // QUOTE multi_term QUOTE ":" (obj | state_ref)
  public static boolean term_kv(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_kv")) return false;
    if (!nextTokenIs(b, QUOTE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, TERM_KV, null);
    r = consumeToken(b, QUOTE);
    r = r && multi_term(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, consumeToken(b, QUOTE));
    r = p && report_error_(b, consumeToken(b, ":")) && r;
    r = p && term_kv_4(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // obj | state_ref
  private static boolean term_kv_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_kv_4")) return false;
    boolean r;
    r = obj(b, l + 1);
    if (!r) r = state_ref(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "$" SYMBOL
  public static boolean var_reference(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_reference")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_REFERENCE, "<var reference>");
    r = consumeToken(b, "$");
    r = r && consumeToken(b, SYMBOL);
    exit_section_(b, l, m, r, false, null);
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
