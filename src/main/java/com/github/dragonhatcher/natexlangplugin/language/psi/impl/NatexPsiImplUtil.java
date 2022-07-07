package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateDeclaration;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateRef;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;

public class NatexPsiImplUtil {
    private static String findStateName(PsiElement element) {
        ASTNode stateName = element.getNode().findChildByType(NatexTypes.STATE_NAME);
        if (stateName != null) {
            ASTNode stateNode = stateName.findChildByType(NatexTypes.SYMBOL);
            if (stateNode != null) {
                return stateNode.getText().trim();
            }
        }
        return null;
    }

    public static String getDeclaredStateName(NatexStateDeclaration element) {
        return findStateName(element);
    }

    public static String getName(NatexStateName element) {
        ASTNode stateNode = element.getNode().findChildByType(NatexTypes.SYMBOL);
        if (stateNode != null) {
            return stateNode.getText().trim();
        } else {
            return null;
        }
    }

    public static String getReferencedStateName(NatexStateRef element) {
        return findStateName(element);
    }
}
