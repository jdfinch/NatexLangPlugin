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
    @Override
    public void getLanguagesToInject(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement element) {
        if (element instanceof PyDictLiteralExpression) {
            registrar.startInjecting(NatexLanguage.INSTANCE);

            recurseOnChildren(registrar, element, 1);

            registrar.doneInjecting();
        }
    }

    private void recurseOnChildren(@NotNull MultiHostRegistrar registrar, @NotNull PsiElement element, int closing) {
        if (element instanceof PyDictLiteralExpression) {
            boolean first = true;

            for (PsiElement kv : element.getChildren()) {
                if (!(kv instanceof PyKeyValueExpression)) continue;

                PsiElement key = ((PyKeyValueExpression) kv).getKey();
                PsiElement value = ((PyKeyValueExpression) kv).getValue();

                boolean isLast = kv == element.getLastChild();
                boolean isValid = value instanceof PyDictLiteralExpression || value instanceof PyStringLiteralExpression;

                registrar.addPlace(first ? "{\"" : "\"", isValid ? "\":" : "\":,", (PsiLanguageInjectionHost) key, getRange(key));

                assert value != null;
                recurseOnChildren(registrar, value, isLast ? closing + 1 : 1);

                first = false;
            }
        } else if (element instanceof PyStringLiteralExpression) {
            registrar.addPlace("\"", "\"},".repeat(closing), (PsiLanguageInjectionHost) element, getRange(element));
        }
    }

    @Override
    public @NotNull List<? extends Class<? extends PsiElement>> elementsToInjectIn() {
        return List.of(PyDictLiteralExpression.class);
    }

    private TextRange getRange(PsiElement element) {
        return new TextRange(0, element.getTextLength());
    }
}
