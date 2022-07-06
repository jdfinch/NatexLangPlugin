package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.*;
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
        } else if (element instanceof NatexMacro) {
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
                || element instanceof NatexReference
                || element instanceof NatexAssignment) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.BOT_STATEMENT)
                    .create();
        }
    }

}
