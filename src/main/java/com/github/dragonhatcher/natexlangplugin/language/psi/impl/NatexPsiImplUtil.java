package com.github.dragonhatcher.natexlangplugin.language.psi.impl;

import com.github.dragonhatcher.natexlangplugin.language.NatexReference;
import com.github.dragonhatcher.natexlangplugin.language.psi.*;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiReference;

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

    public static String getName(NatexStateDeclaration element) {
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

    public static PsiElement setName(NatexStateDeclaration element, String newName) {
        ASTNode stateNode = element.getNode().findChildByType(NatexTypes.STATE_NAME);
        if (stateNode != null) {
            ASTNode symbol = stateNode.findChildByType(NatexTypes.SYMBOL);
            if (symbol != null) {
                NatexStateName stateName = NatexElementFactory.createStateName(element.getProject(), newName);
                ASTNode newSymbolNode = stateName.getFirstChild().getNode();
                element.getNode().replaceChild(symbol, newSymbolNode);
            }
        }
        return element;
    }

    public static PsiElement setName(NatexStateName element, String newName) {
        ASTNode symbol = element.getNode().findChildByType(NatexTypes.SYMBOL);
        if (symbol != null) {
            NatexStateName stateName = NatexElementFactory.createStateName(element.getProject(), newName);
            ASTNode newSymbolNode = stateName.getFirstChild().getNode();
            element.getNode().replaceChild(symbol, newSymbolNode);
        }

        return element;
    }

    public static PsiElement getNameIdentifier(NatexStateDeclaration element) {
        ASTNode stateNode = element.getNode().findChildByType(NatexTypes.STATE_NAME);
        if (stateNode != null) {
            ASTNode symbol = stateNode.findChildByType(NatexTypes.SYMBOL);
            return symbol != null ? stateNode.getPsi() : null;
        } else {
            return null;
        }
    }

    public static String getReferencedStateName(NatexStateRef element) {
        return findStateName(element);
    }

    public static PsiReference getReference(NatexStateName element) {
        var symbol = element.getNode().findChildByType(NatexTypes.SYMBOL);
        if (symbol != null && !(element.getParent() instanceof NatexStateDeclaration)) {
            return new NatexReference(element, new TextRange(0, element.getTextLength()));
        }

        return null;
    }
}
