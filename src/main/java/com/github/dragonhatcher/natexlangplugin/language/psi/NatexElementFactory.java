package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.github.dragonhatcher.natexlangplugin.language.NatexFileType;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.intellij.psi.util.PsiTreeUtil;

public class NatexElementFactory {

    public static NatexStateName createStateName(Project project, String name) {
        NatexFile file = createFile(project, "{ 'state': '" + name +"'}");
        return PsiTreeUtil.findChildOfType(file, NatexStateName.class);
    }

    public static NatexFile createFile(Project project, String text) {
        String name = "dummy.natex";
        return (NatexFile) PsiFileFactory.getInstance(project).
                createFileFromText(name, NatexFileType.INSTANCE, text);
    }
}
