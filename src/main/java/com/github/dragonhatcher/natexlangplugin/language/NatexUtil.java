package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexFile;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateDeclaration;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.lang.injection.InjectedLanguageManager;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NatexUtil {

    private static List<NatexFile> getNatexFiles(PsiElement element) {
        Project project = element.getProject();
        InjectedLanguageManager injectedLanguageManager = InjectedLanguageManager.getInstance(project);
        var elementHost = injectedLanguageManager.getInjectionHost(element);
        Stream<PsiElement> pythonFileFiles = Stream.empty();
        if (elementHost != null) {
            var pyFile = elementHost.getContainingFile();

            List<PsiLanguageInjectionHost> hosts = getChildrenOfTypeRecurse(pyFile, PsiLanguageInjectionHost.class);

            pythonFileFiles = hosts
                    .stream()
                    .flatMap(h -> {
                        var injectedPsiFiles = injectedLanguageManager.getInjectedPsiFiles(h);
                        return injectedPsiFiles == null ? Stream.empty() : injectedPsiFiles.stream();
                    })
                    .map(p -> p.first);
        }
        NatexFile elementNatexFile = getRoot(element);

        return Stream
                .concat(pythonFileFiles, elementNatexFile == null ? Stream.empty() : Stream.of(elementNatexFile))
                .distinct()
                .filter(Objects::nonNull)
                .filter(e -> e instanceof NatexFile)
                .map(e -> (NatexFile)e)
                .collect(Collectors.toList());
    }

    public static List<NatexStateName> findStateNameReferences(PsiElement element, String searchStateName) {
        if (searchStateName == null) {
            return List.of();
        }

        return findAllStateNames(element)
                .stream()
                .filter(sn -> searchStateName.equals(sn.getName()))
                .collect(Collectors.toList());
    }

    public static List<NatexStateDeclaration> findStateNameDeclarations(PsiElement element, String searchStateName) {
//        System.out.println("Finding declarations for " + searchStateName);
//        for (VirtualFile pythonFile : FileTypeIndex.getFiles(PythonFileType.INSTANCE, GlobalSearchScope.allScope(element.getProject()))) {
//            PsiFile psiFIle = PsiManager.getInstance(element.getProject()).findFile(pythonFile);
//            if (psiFIle == null || !pythonFile.getName().equals("main.py")) continue;
//
//            var hosts = getChildrenOfTypeRecurse(psiFIle, PsiLanguageInjectionHost.class);
//
//            for (PsiLanguageInjectionHost host : hosts) {
//                var x = InjectedLanguageManager.getInstance(element.getProject()).getInjectedPsiFiles(host);
//                System.out.println(x);
//            }
//        }

        if (searchStateName == null) {
            return List.of();
        }

        return findAllStateDeclarations(element)
                .stream()
                .filter(sn -> searchStateName.equals(sn.getName()))
                .collect(Collectors.toList());

//        System.out.println("Found " + declarations.size());
    }

    public static List<NatexStateDeclaration> findAllStateDeclarations(PsiElement element) {
        List<NatexStateDeclaration> result = new ArrayList<>();

        for (NatexFile natexFile : getNatexFiles(element)) {
            List<NatexStateDeclaration> stateNames = getChildrenOfTypeRecurse(natexFile, NatexStateDeclaration.class);

            if (stateNames != null) {
                result.addAll(stateNames);
            }
        }

//        System.out.println("Declarations:");
//        System.out.println(result.stream().map(NatexStateDeclaration::getDeclaredStateName).collect(Collectors.toList()));

        return result;
    }

    public static List<NatexStateName> findAllStateNames(PsiElement element) {
        List<NatexStateName> result = new ArrayList<>();

        for (NatexFile natexFile : getNatexFiles(element)) {
            List<NatexStateName> stateNames = getChildrenOfTypeRecurse(natexFile, NatexStateName.class);

            if (stateNames != null) {
                result.addAll(stateNames);
            }
        }

        return result;
    }

    private static NatexFile getRoot(PsiElement element) {
        return PsiTreeUtil.getTopmostParentOfType(element, NatexFile.class);
    }

    private static <T extends PsiElement> List<T> getChildrenOfTypeRecurse(@Nullable PsiElement element, @NotNull Class<T> aClass) {
        if (element == null) return new ArrayList<>();

        return Stream.concat(
                Arrays.stream(element.getChildren())
                        .flatMap(e -> getChildrenOfTypeRecurse(e, aClass).stream()),
                PsiTreeUtil.getChildrenOfTypeAsList(element, aClass).stream()
        ).collect(Collectors.toList());
    }
}
