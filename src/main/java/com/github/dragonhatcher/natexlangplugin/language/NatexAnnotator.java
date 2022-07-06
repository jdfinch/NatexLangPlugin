package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.stream.Collectors;

public class NatexAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (!(element instanceof NatexStateName)) {
            return;
        }

        Project project = element.getProject();
        String stateName = ((NatexStateName) element).getState();
        List<NatexStateName> stateNames = NatexUtil
                .findStateNames(project, stateName);

        if (stateNames.size() > 1) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.STATE_NAME)
                    .create();
        } else {
            holder
                    .newAnnotation(HighlightSeverity.WARNING, "Unresolved state.")
                    .range(element)
                    .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
//                    .textAttributes(NatexSyntaxHighlighter.STATE_NAME)
                    .create();
        }
    }
}
