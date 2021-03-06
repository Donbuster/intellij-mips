/*
 * Copyright 2017 Niklas Persson
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.equadon.intellij.mips.lang.psi.mixins;

import com.equadon.intellij.mips.lang.psi.MipsElementTypes;
import com.equadon.intellij.mips.lang.psi.impl.MipsNamedElementImpl;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MipsLabelIdentifierMixin extends MipsNamedElementImpl {
  public MipsLabelIdentifierMixin(@NotNull ASTNode node) {
    super(node);
  }

  @Nullable
  @Override
  public PsiElement getNameIdentifier() {
    PsiElement child = getFirstChild();

    if (child != null) {
      IElementType type = child.getNode().getElementType();

      if (type == MipsElementTypes.IDENTIFIER || type == MipsElementTypes.OPERATOR)
        return child;
    }

    return null;
  }
}
