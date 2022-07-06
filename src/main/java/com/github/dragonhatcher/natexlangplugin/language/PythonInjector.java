package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.openapi.util.TextRange;
import com.intellij.psi.InjectedLanguagePlaces;
import com.intellij.psi.LanguageInjector;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.jetbrains.python.psi.PyKeyValueExpression;
import org.jetbrains.annotations.NotNull;

public class PythonInjector implements LanguageInjector {
    @Override
    public void getLanguagesToInject(@NotNull PsiLanguageInjectionHost host, @NotNull InjectedLanguagePlaces injectedLanguagePlaces) {
        if (host.getParent() instanceof PyKeyValueExpression) {
            TextRange range = new TextRange(1, host.getTextLength() - 1);
            injectedLanguagePlaces.addPlace(NatexLanguage.INSTANCE, range, "", "");
        }
    }
}
