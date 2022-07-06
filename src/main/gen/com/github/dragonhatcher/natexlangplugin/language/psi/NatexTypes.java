// This is a generated file. Not intended for manual editing.
package com.github.dragonhatcher.natexlangplugin.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.dragonhatcher.natexlangplugin.language.psi.impl.*;

public interface NatexTypes {

  IElementType PROPERTY = new NatexElementType("PROPERTY");

  IElementType COMMENT = new NatexTokenType("COMMENT");
  IElementType CRLF = new NatexTokenType("CRLF");
  IElementType KEY = new NatexTokenType("KEY");
  IElementType SEPARATOR = new NatexTokenType("SEPARATOR");
  IElementType VALUE = new NatexTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new NatexPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
