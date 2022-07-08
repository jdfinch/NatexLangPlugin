package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.impl.NatexObjImpl;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class NatexCompletionContributor extends CompletionContributor {

    public NatexCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement().inside(NatexObjImpl.class),
                new CompletionProvider<>() {
                    @Override
                    protected void addCompletions(
                            @NotNull CompletionParameters parameters,
                            @NotNull ProcessingContext context,
                            @NotNull CompletionResultSet resultSet) {
                        System.out.println("Entered");
                        resultSet.addElement(LookupElementBuilder.create("'state':"));
                        resultSet.addElement(LookupElementBuilder.create("'score':"));
                        resultSet.addElement(LookupElementBuilder.create("'speaker':"));
                    }
                });
    }
}
