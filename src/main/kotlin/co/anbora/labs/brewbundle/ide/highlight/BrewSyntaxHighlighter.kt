package co.anbora.labs.brewbundle.ide.highlight

import co.anbora.labs.brewbundle.lang.lexer.BrewBundleLexer
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class BrewSyntaxHighlighter: SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer = BrewBundleLexer()

    override fun getTokenHighlights(
        tokenType: IElementType?
    ): Array<TextAttributesKey> = pack(tokenType.textAttributesKey())
}