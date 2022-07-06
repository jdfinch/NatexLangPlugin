package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.lexer.FlexAdapter;

public class NatexLexerAdapter extends FlexAdapter {

    public NatexLexerAdapter() {
        super(new NatexLexer(null));
    }
}
