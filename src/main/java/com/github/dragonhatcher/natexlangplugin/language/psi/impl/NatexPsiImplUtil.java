package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.lang.ASTNode;

public class NatexPsiImplUtil {
    public static String getState(NatexStateName element) {
        ASTNode stateNode = element.getNode().findChildByType(NatexTypes.SYMBOL);
        if (stateNode != null) {
            return stateNode.getText().trim();
        } else {
            return null;
        }
    }
}
