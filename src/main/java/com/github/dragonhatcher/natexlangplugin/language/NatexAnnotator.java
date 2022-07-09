package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.*;
import com.intellij.codeInsight.daemon.impl.quickfix.RenameElementFix;
import com.intellij.codeInspection.ProblemHighlightType;
import com.intellij.lang.annotation.AnnotationHolder;
import com.intellij.lang.annotation.Annotator;
import com.intellij.lang.annotation.HighlightSeverity;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

public class NatexAnnotator implements Annotator {

    @Override
    public void annotate(@NotNull PsiElement element, @NotNull AnnotationHolder holder) {
        if (element instanceof NatexStateName) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.STATE_NAME)
                    .create();
        }

        if (element instanceof NatexStateRef) {
            String name = ((NatexStateRef) element).getReferencedStateName();
            if (NatexUtil.findStateNameDeclarations(element, name).isEmpty() && !name.contains(":")) {
                var stateName = element.getNode().findChildByType(NatexTypes.STATE_NAME);
                if (stateName != null) {
                    var symbol = stateName.findChildByType(NatexTypes.SYMBOL);

                    holder
                            .newAnnotation(HighlightSeverity.ERROR, "Unknown state")
                            .range(symbol == null ? element.getNode() : symbol)
                            .highlightType(ProblemHighlightType.LIKE_UNKNOWN_SYMBOL)
                            .create();
                }
            }
        }

        if (element instanceof NatexMacro) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.MACRO)
                    .create();
        } else if (element instanceof NatexSequence
                || element instanceof NatexConjunction
                || element instanceof NatexDisjunction
                || element instanceof NatexOptional
                || element instanceof NatexKleeneStar
                || element instanceof NatexKleenePlus
                || element instanceof NatexNegation
                || element instanceof NatexVarReference
                || element instanceof NatexAssignment) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.BOT_STATEMENT)
                    .create();
        }
    }

}
