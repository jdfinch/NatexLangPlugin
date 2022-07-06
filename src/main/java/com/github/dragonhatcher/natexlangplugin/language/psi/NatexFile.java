package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.github.dragonhatcher.natexlangplugin.language.NatexFileType;
import com.github.dragonhatcher.natexlangplugin.language.NatexLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class NatexFile extends PsiFileBase {

    public NatexFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, NatexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return NatexFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Natex File";
    }
}
