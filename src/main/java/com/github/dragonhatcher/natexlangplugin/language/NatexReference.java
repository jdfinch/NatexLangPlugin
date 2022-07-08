package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateDeclaration;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NatexReference extends PsiReferenceBase<PsiElement> implements PsiPolyVariantReference {

    private final String stateName;

    public NatexReference(@NotNull PsiElement element, TextRange textRange) {
        super(element, textRange);
        stateName = element.getText().substring(textRange.getStartOffset(), textRange.getEndOffset());
    }

    @Override
    public ResolveResult @NotNull [] multiResolve(boolean incompleteCode) {
        final List<NatexStateDeclaration> stateNames = NatexUtil.findStateNameDeclarations(myElement, stateName);
        List<ResolveResult> results = new ArrayList<>();
        for (NatexStateDeclaration stateName : stateNames) {
            results.add(new PsiElementResolveResult(stateName));
        }
        return results.toArray(new ResolveResult[results.size()]);
    }

    @Nullable
    @Override
    public PsiElement resolve() {
        ResolveResult[] resolveResults = multiResolve(false);
        return resolveResults.length == 1 ? resolveResults[0].getElement() : null;
    }

    @Override
    public Object @NotNull [] getVariants() {
        List<NatexStateName> stateNames = NatexUtil.findAllStateNames(myElement);
        List<LookupElement> variants = new ArrayList<>();
        Set<String> added = new HashSet<>();
        for (final NatexStateName stateName : stateNames) {
            if (stateName.getName() != null
                    && stateName.getName().length() > 0
                    && !added.contains(stateName.getName())
            ) {
                variants.add(LookupElementBuilder.create(stateName));
                added.add(stateName.getName());
            }
        }
        return variants.toArray();
    }

    @Override
    public PsiElement handleElementRename(@NotNull String newElementName) {
        System.out.println("handleElementRename Called");

        if (myElement instanceof NatexStateName) {
            ((NatexStateName) myElement).setName(newElementName);
        }
        return myElement;
    }

}
