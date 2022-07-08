package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexFile;
import com.github.dragonhatcher.natexlangplugin.language.psi.impl.NatexObjImpl;
import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElement;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.codeInsight.template.Expression;
import com.intellij.codeInsight.template.TemplateBuilder;
import com.intellij.codeInsight.template.TemplateBuilderFactory;
import com.intellij.codeInsight.template.impl.*;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.PsiElement;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

public class NatexCompletionContributor extends CompletionContributor {

    public NatexCompletionContributor() {
//        extend(CompletionType.BASIC, PlatformPatterns.psiElement().inside(NatexFile.class),
//                new CompletionProvider<>() {
//                    @Override
//                    protected void addCompletions(
//                            @NotNull CompletionParameters parameters,
//                            @NotNull ProcessingContext context,
//                            @NotNull CompletionResultSet resultSet) {
//                        System.out.println("Entered");
//
//                        var templateImpl = new TemplateImpl("'pattern': ", "Natex");
//                        templateImpl.addVariable(new Variable("pattern", "b", "natex", false));
//                        templateImpl.addVariable(new Variable("state", "b", "state", true));
//                        templateImpl.addTextSegment("'");
//                        templateImpl.addVariableSegment("pattern");
//                        templateImpl.addEndVariable();
//                        templateImpl.addTextSegment("': '");
//                        templateImpl.addVariableSegment("state");
//                        templateImpl.addEndVariable();
//                        templateImpl.addTextSegment("',");
//                        var liveTemplate = new LiveTemplateLookupElementImpl(templateImpl, true);
//                        resultSet.addElement(liveTemplate);
//
//                        var stateTemplateImpl = new TemplateImpl("'state': '',", "Natex");
//                        stateTemplateImpl.addVariable(new Variable("state_name", "stateName", "stateName", false));
//                        stateTemplateImpl.addTextSegment("'state': '");
//                        stateTemplateImpl.addVariableSegment("state_name");
//                        stateTemplateImpl.addEndVariable();
//                        stateTemplateImpl.addTextSegment("',");
//                        resultSet.addElement(new LiveTemplateLookupElementImpl(stateTemplateImpl, true));
//
//                        var scoreTemplateImpl = new TemplateImpl("'score': ,", "Natex");
//                        stateTemplateImpl.addVariable(new Variable("score", "1.0", "1.0", false));
//                        stateTemplateImpl.addTextSegment("'score': ");
//                        stateTemplateImpl.addVariableSegment("score");
//                        stateTemplateImpl.addEndVariable();
//                        stateTemplateImpl.addTextSegment(",");
//                        resultSet.addElement(new LiveTemplateLookupElementImpl(scoreTemplateImpl, true));
//
//                        resultSet.addElement(LookupElementBuilder.create("'speaker':'${},'"));
//                    }
//                }
//                );
    }
}
