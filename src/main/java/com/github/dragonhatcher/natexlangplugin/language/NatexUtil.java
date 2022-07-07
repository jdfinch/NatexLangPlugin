package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexFile;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateDeclaration;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.psi.PsiElement;
import com.intellij.psi.util.PsiTreeUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NatexUtil {

//    private static List<NatexFile> getNatexFile(Project project) {
//        List<NatexFile> result = new ArrayList<>();
//
//        List<VirtualFile> files = new ArrayList<>();
//        files.addAll(FileTypeIndex.getFiles(NatexFileType.INSTANCE, GlobalSearchScope.allScope(project)));
//
//        for (VirtualFile pythonFile : FileTypeIndex.getFiles(PythonFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
//            PsiFile psiFile = PsiManager.getInstance(project).findFile(pythonFile);
//
//            if (psiFile != null) {
//                List<PsiLanguageInjectionHost> hosts = getChildrenOfTypeRecurse(psiFile, PsiLanguageInjectionHost.class);
//
//                System.out.println("Hosts: " + hosts.size());
//            }
//
//            FileViewProvider viewProvider = PsiManager
//                    .getInstance(project)
//                    .findViewProvider(virtualFile);
//            if (viewProvider == null) continue;
//
//            List<NatexFile> natexFiles = viewProvider
//                    .getAllFiles()
//                    .stream()
//                    .filter(file -> file instanceof NatexFile)
//                    .map(file -> (NatexFile) file)
//                    .collect(Collectors.toList());
//
//            result.addAll(natexFiles);
//        }
//
//        for (VirtualFile natexFile : FileTypeIndex.getFiles(NatexFileType.INSTANCE, GlobalSearchScope.allScope(project))) {
//            NatexFile psiFile = (NatexFile) PsiManager.getInstance(project).findFile(natexFile);
//            if (psiFile != null) {
//                result.add(psiFile);
//            }
//        }
//
//        System.out.println("Files:");
//        System.out.println(result);
//
//        return result;
//    }

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

        if (searchStateName == null) {
            return List.of();
        }

        return findAllStateDeclarations(element)
                .stream()
                .filter(sn -> searchStateName.equals(sn.getDeclaredStateName()))
                .collect(Collectors.toList());

//        System.out.println("Found " + declarations.size());
    }

    public static List<NatexStateDeclaration> findAllStateDeclarations(PsiElement element) {
        List<NatexStateDeclaration> result = new ArrayList<>();

        NatexFile natexFile = getRoot(element);

        if (natexFile != null) {
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

        NatexFile natexFile = getRoot(element);

        if (natexFile != null) {
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
