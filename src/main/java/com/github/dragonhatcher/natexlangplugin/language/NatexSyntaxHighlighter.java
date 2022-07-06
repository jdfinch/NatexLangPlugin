package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.editor.markup.EffectType;
import com.intellij.openapi.editor.markup.TextAttributes;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import com.intellij.ui.JBColor;
import org.jetbrains.annotations.NotNull;

import java.awt.*;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NatexSyntaxHighlighter extends SyntaxHighlighterBase {

    private static final Color PURPLE_COL = new JBColor(new Color(152, 126, 170), new Color(152, 126, 170));
    private static final Color YELLOW_COL = new JBColor(new Color(255, 199, 109), new Color(255, 199, 109));

    private static final TextAttributes PURPLE = new TextAttributes(PURPLE_COL, null, null, EffectType.BOLD_DOTTED_LINE, Font.PLAIN);
    private static final TextAttributes YELLOW = new TextAttributes(YELLOW_COL, null, null, EffectType.BOLD_DOTTED_LINE, Font.PLAIN);

    public static final TextAttributesKey PUNCTUATION =
            createTextAttributesKey("NATEX_PUNCTUATION", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    public static final TextAttributesKey LITERAL =
            createTextAttributesKey("NATEX_LITERAL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEY =
            createTextAttributesKey("NATEX_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey REGEX =
            createTextAttributesKey("NATEX_REGEX", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SYMBOL =
            createTextAttributesKey("NATEX_SYMBOL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey STATE_NAME =
            createTextAttributesKey("NATEX_STATE_NAME", PURPLE);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("NATEX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] PUNCTUATION_KEYS = new TextAttributesKey[]{PUNCTUATION};
    private static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
    private static final TextAttributesKey[] REGEX_KEYS = new TextAttributesKey[]{REGEX};
    private static final TextAttributesKey[] SYMBOL_KEYS = new TextAttributesKey[]{SYMBOL};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY};
    private static final TextAttributesKey[] STATE_NAME_KEYS = new TextAttributesKey[]{STATE_NAME};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new NatexLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NatexTypes.PUNCUATION)
                || tokenType.equals(NatexTypes.L_PAREN)
                || tokenType.equals(NatexTypes.R_PAREN)
                || tokenType.equals(NatexTypes.L_CURLY)
                || tokenType.equals(NatexTypes.R_CURLY)
                || tokenType.equals(NatexTypes.L_BRACKET)
                || tokenType.equals(NatexTypes.R_BRACKET)
                || tokenType.equals(NatexTypes.L_ARROW)
                || tokenType.equals(NatexTypes.R_ARROW)) {
            return PUNCTUATION_KEYS;
        }
        if (tokenType.equals(NatexTypes.LITERAL) || tokenType.equals(NatexTypes.MACRO_LITERAL) || tokenType.equals(NatexTypes.MACRO_ARG_STRING)) {
            return LITERAL_KEYS;
        }
        if (tokenType.equals(NatexTypes.REGEX)) {
            return REGEX_KEYS;
        }
        if (tokenType.equals(NatexTypes.SYMBOL)) {
            return SYMBOL_KEYS;
        }
        if (tokenType.equals(NatexTypes.KEYWORD)) {
            return KEY_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}
