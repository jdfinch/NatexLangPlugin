package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.lang.BracePair;
import com.intellij.lang.PairedBraceMatcher;
import com.intellij.psi.PsiFile;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NatexBraceMatcher implements PairedBraceMatcher {
    @Override
    public BracePair @NotNull [] getPairs() {
        return new BracePair[]{
                new BracePair(NatexTypes.L_PAREN, NatexTypes.R_PAREN, true),
                new BracePair(NatexTypes.L_CURLY, NatexTypes.R_CURLY, true),
                new BracePair(NatexTypes.L_BRACKET, NatexTypes.R_BRACKET, true),
                new BracePair(NatexTypes.L_ARROW, NatexTypes.R_ARROW, true),
        };
    }

    @Override
    public boolean isPairedBracesAllowedBeforeType(@NotNull IElementType lbraceType, @Nullable IElementType contextType) {
        return true;
    }

    @Override
    public int getCodeConstructStart(PsiFile file, int openingBraceOffset) {
        return openingBraceOffset;
    }
}
