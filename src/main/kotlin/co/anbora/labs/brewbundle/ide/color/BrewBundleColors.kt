package co.anbora.labs.brewbundle.ide.color

import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.markup.TextAttributes
import com.intellij.openapi.options.colors.AttributesDescriptor
import java.awt.Color
import java.awt.Font

enum class BrewBundleColors(humanName: String, default: TextAttributesKey) {

    KEY_WORD("Keywords", DefaultLanguageHighlighterColors.KEYWORD),
    BAD_CHAR("Bad Character", HighlighterColors.BAD_CHARACTER),
    ENVIRONMENT("Envs", TextAttributesKey.createTextAttributesKey("DEFAULT_ENVS", DefaultLanguageHighlighterColors.NUMBER)),
    STRINGS("Literals//Strings", DefaultLanguageHighlighterColors.STRING),
    NUMBERS("Literals//Numbers", DefaultLanguageHighlighterColors.NUMBER),
    COMMENTS("Comments", DefaultLanguageHighlighterColors.LINE_COMMENT),
    OPTIONS(
        "Options",
        TextAttributesKey.createTempTextAttributesKey(
            "BREW_FIELDS",
            TextAttributes(Color.decode("#8A653B"), null, null, null, Font.PLAIN)
        )
    ),
    COLON("Operators//Colon", DefaultLanguageHighlighterColors.SEMICOLON),
    DOT("Operators//Dot", DefaultLanguageHighlighterColors.DOT),
    COMMA("Operators//Comma", DefaultLanguageHighlighterColors.COMMA);

    val textAttributesKey = TextAttributesKey.createTextAttributesKey("co.anbora.labs.brewbundle.$name", default)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
    val testSeverity: HighlightSeverity = HighlightSeverity(name, HighlightSeverity.INFORMATION.myVal)
}