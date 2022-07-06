package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.lang.Language;

public class NatexLanguage extends Language {

    public static final NatexLanguage INSTANCE = new NatexLanguage();

    private NatexLanguage() {
        super("Natex");
    }
}
