package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexNamedElement;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class NatexNamedElementImpl extends ASTWrapperPsiElement implements NatexNamedElement {

    public NatexNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }
}
