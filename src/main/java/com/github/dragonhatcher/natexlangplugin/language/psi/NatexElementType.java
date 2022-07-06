package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.github.dragonhatcher.natexlangplugin.language.NatexLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class NatexElementType extends IElementType {

    public NatexElementType(@NotNull @NonNls String debugName) {
        super(debugName, NatexLanguage.INSTANCE);
    }
}
