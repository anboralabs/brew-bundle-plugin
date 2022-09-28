package co.anbora.labs.brewbundle.lang.core.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement

interface BrewElement: PsiElement

abstract class BrewElementImpl(
    node: ASTNode
) : ASTWrapperPsiElement(node), BrewElement