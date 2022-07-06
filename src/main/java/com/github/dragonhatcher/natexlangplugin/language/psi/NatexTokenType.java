package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.github.dragonhatcher.natexlangplugin.language.NatexLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class NatexTokenType extends IElementType {
    public NatexTokenType(@NotNull @NonNls String debugName) {
        super(debugName, NatexLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "NatexTokenType." + super.toString();
    }
}
