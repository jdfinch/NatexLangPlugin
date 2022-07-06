package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NatexLineMarkerProvider extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        if (!(element instanceof NatexStateName)) {
            return;
        }

        Project project = element.getProject();
        String stateName = ((NatexStateName) element).getState();
        List<NatexStateName> stateNames = NatexUtil
                .findStateNames(project, stateName)
                .stream()
                .filter((sn) -> sn != element)
                .collect(Collectors.toList());

        if (stateNames.size() > 0) {
            NavigationGutterIconBuilder<PsiElement> builder =
                    NavigationGutterIconBuilder.create(NatexIcons.FILE)
                            .setTargets(stateNames)
                            .setTooltipText("Navigate to state.");
            result.add(builder.createLineMarkerInfo(element));
        }
    }
}
