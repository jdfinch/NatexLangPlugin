package com.github.dragonhatcher.natexlangplugin.language;

import com.github.dragonhatcher.natexlangplugin.language.psi.NatexFile;
import com.github.dragonhatcher.natexlangplugin.language.psi.NatexStateName;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiManager;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class NatexUtil {

    public static List<NatexStateName> findStateNames(Project project, String searchStateName) {
        List<NatexStateName> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NatexFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NatexFile natexFile = (NatexFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (natexFile != null) {
                NatexStateName[] stateNames = PsiTreeUtil.getChildrenOfType(natexFile, NatexStateName.class);
                if (stateNames != null) {
                    for (NatexStateName stateName : stateNames) {
                        if (searchStateName.equals(stateName.getState())) {
                            result.add(stateName);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<NatexStateName> findStateNames(Project project) {
        List<NatexStateName> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(NatexFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            NatexFile natexFile = (NatexFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (natexFile != null) {
                NatexStateName[] stateNames = PsiTreeUtil.getChildrenOfType(natexFile, NatexStateName.class);
                if (stateNames != null) {
                    Collections.addAll(result, stateNames);
                }
            }
        }
        return result;
    }
}
