package co.anbora.labs.brewbundle.ide.typing

import com.intellij.lang.BracePair
import com.intellij.lang.PairedBraceMatcher
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IElementType
import co.anbora.labs.brewbundle.lang.core.psi.BrewTypes.*

private val bracePairs = arrayOf(
    BracePair(L_PAREN, R_PAREN, false),
    BracePair(L_BRACK, R_BRACK, false),
    BracePair(L_BRACE, R_BRACE, true))

class BrewBraceMatcher: PairedBraceMatcher {
    override fun getPairs(): Array<BracePair> = bracePairs

    override fun isPairedBracesAllowedBeforeType(
        lbraceType: IElementType,
        contextType: IElementType?
    ): Boolean = true

    override fun getCodeConstructStart(
        file: PsiFile?,
        openingBraceOffset: Int
    ): Int = openingBraceOffset
}
