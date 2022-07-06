package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class NatexSyntaxHighlighter extends SyntaxHighlighterBase {

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
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("NATEX_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);


    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] PUNCTUATION_KEYS = new TextAttributesKey[]{PUNCTUATION};
    private static final TextAttributesKey[] LITERAL_KEYS = new TextAttributesKey[]{LITERAL};
    private static final TextAttributesKey[] REGEX_KEYS = new TextAttributesKey[]{REGEX};
    private static final TextAttributesKey[] SYMBOL_KEYS = new TextAttributesKey[]{SYMBOL};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new NatexLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(NatexTypes.PUNCUATION)) {
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
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}