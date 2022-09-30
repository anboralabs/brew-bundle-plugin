package co.anbora.labs.brewbundle.ide.highlight

import co.anbora.labs.brewbundle.ide.color.BrewBundleColors
import co.anbora.labs.brewbundle.lang.core.KEYWORDS
import co.anbora.labs.brewbundle.lang.core.psi.BrewTypes.*
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType

fun IElementType?.textAttributesKey(): TextAttributesKey? = map(this)?.textAttributesKey

private fun map(tokenType: IElementType?): BrewBundleColors? {
    return when (tokenType) {
        in KEYWORDS, BOOL_LITERAL -> BrewBundleColors.KEY_WORD
        ENVIRONMENT -> BrewBundleColors.ENVIRONMENT
        STRING_LITERAL -> BrewBundleColors.STRINGS
        IDENTIFIER -> BrewBundleColors.OPTIONS
        COLON -> BrewBundleColors.COLON
        DOT -> BrewBundleColors.DOT
        COMMA -> BrewBundleColors.COMMA
        NUMBER_LITERAL -> BrewBundleColors.NUMBERS
        TokenType.BAD_CHARACTER -> BrewBundleColors.BAD_CHAR
        else -> null
    }
}