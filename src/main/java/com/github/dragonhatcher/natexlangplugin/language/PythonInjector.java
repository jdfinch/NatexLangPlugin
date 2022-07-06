package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.lang.injection.MultiHostInjector;
import com.intellij.lang.injection.MultiHostRegistrar;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.jetbrains.python.psi.PyDictLiteralExpression;
import com.jetbrains.python.psi.PyKeyValueExpression;
import com.jetbrains.python.psi.PyStringLiteralExpression;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PythonInjector implements MultiHostInjector {

    String currentBefore = "";
    String currentAfter = "";
    PsiElement nextElement = null;
    MultiHostRegistrar registrar;

    String fullOut = "";

    synchronized private void start(MultiHostRegistrar registrar) {
        fullOut = "";
        currentBefore = "";
        currentAfter = "";
        nextElement = null;
        this.registrar = registrar;
        registrar.startInjecting(NatexLanguage.INSTANCE);
    }

    synchronized private void write(String str) {
        if (nextElement == null) {
            currentBefore += str;
        } else {
            currentAfter += str;
        }
    }

    synchronized private void write(PsiElement element) {
        if (nextElement != null) {
            fullOut += currentBefore + nextElement.getText();
            registrar.addPlace(currentBefore, null, (PsiLanguageInjectionHost) nextElement, getRange(nextElement));
            currentBefore = currentAfter;
            currentAfter = "";
        }
        nextElement = element;
    }

    synchronized private void write(String before, PsiElement element, String after) {
        write(before);
        write(element);
        write(after);
    }

    synchronized private void finish() {
        if (nextElement != null) {
            fullOut += currentBefore + nextElement.getText() + currentAfter;
            registrar.addPlace(currentBefore, currentAfter, (PsiLanguageInjectionHost) nextElement, getRange(nextElement));
        }
    }

    @Override
    synchronized public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement element) {
        if (element instanceof PyDictLiteralExpression) {
            start(registrar);

            recurseOnChildren(element);

            finish();

            try {
                registrar.doneInjecting();
            } catch (Exception e) {
                // Nothing to highlight.
            }
        }
    }

    synchronized private void recurseOnChildren(PsiElement element) {
        if (element == null) return;

        if (element instanceof PyDictLiteralExpression) {
            PsiElement[] children = element.getChildren();

            write("{");

            for (PsiElement kv : children) {
                if (!(kv instanceof PyKeyValueExpression)) continue;

                PsiElement key = ((PyKeyValueExpression) kv).getKey();
                PsiElement value = ((PyKeyValueExpression) kv).getValue();

                if (key instanceof PyStringLiteralExpression) {
                    write("\"", key, "\":");
                    recurseOnChildren(value);
                } else if (value instanceof PyDictLiteralExpression) {
                    recurseOnChildren(value);
                }

                write(",");
            }

            write("}");
        } else if (element instanceof PyStringLiteralExpression) {
            write("\"", element, "\"");
        }
    }

    @Override
    synchronized public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(PyDictLiteralExpression.class);
    }

    synchronized private TextRange getRange(PsiElement element) {
        return new TextRange(0, element.getTextLength());
    }
}
