package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateDeclaration;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateRef;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexTypes;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerInfo;
import com.intellij.codeInsight.daemon.RelatedItemLineMarkerProvider;
import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NatexLineMarkerProvider extends RelatedItemLineMarkerProvider {

    @Override
    protected void collectNavigationMarkers(@NotNull PsiElement element,
                                            @NotNull Collection<? super RelatedItemLineMarkerInfo<?>> result) {
        if (element.getNode().getElementType() == NatexTypes.SYMBOL
                && element.getParent() instanceof NatexStateName
                && element.getParent().getParent() instanceof NatexStateRef
        ) {
            String stateName = element.getText().trim();
            List<NatexStateDeclaration> stateNames = NatexUtil.findStateNameDeclarations(element, stateName);

            if (stateNames.size() > 0) {
                var marker =
                        NavigationGutterIconBuilder
                                .create(AllIcons.Gutter.ImplementingMethod)
                                .setTargets(stateNames)
                                .setTooltipText("Navigate to state.")
                                .createLineMarkerInfo(element);
                result.add(marker);
            }
        } else if (element.getNode().getElementType() == NatexTypes.SYMBOL
                && element.getParent() instanceof NatexStateName
                && element.getParent().getParent() instanceof NatexStateDeclaration
        ) {
            String stateName = element.getText().trim();
            List<NatexStateName> stateNames =
                    NatexUtil
                            .findStateNameReferences(element, stateName)
                            .stream()
                            .filter(sn -> !sn.equals(element.getParent()))
                            .collect(Collectors.toList());

            if (stateNames.size() > 0) {
                var marker =
                        NavigationGutterIconBuilder
                                .create(AllIcons.Gutter.OverridenMethod)
                                .setTargets(stateNames)
                                .setTooltipText("Navigate to state uses.")
                                .createLineMarkerInfo(element);
                result.add(marker);
            }
        }
    }

}
