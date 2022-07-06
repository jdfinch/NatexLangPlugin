package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexFile;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexMultiTerm;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexSystemKv;
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
        } else if (element instanceof NatexMultiTerm && element.getText().matches(".*[{}\\[\\]<>#].*")) {
            holder
                    .newSilentAnnotation(HighlightSeverity.INFORMATION)
                    .range(element)
                    .textAttributes(NatexSyntaxHighlighter.BOT_STATEMENT)
                    .create();
        }
    }
}
