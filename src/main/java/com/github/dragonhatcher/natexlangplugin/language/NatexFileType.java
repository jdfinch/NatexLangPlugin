package com.github.dragonhatcher.natexlangplugin.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class NatexFileType extends LanguageFileType {

    public static final NatexFileType INSTANCE = new NatexFileType();

    private NatexFileType() {
        super(NatexLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Natex File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Natex language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "natex";
    }

    @Nullable
    @Override
    public Icon getIcon() {
        return null;
    }

}
