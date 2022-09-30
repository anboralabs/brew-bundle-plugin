package co.anbora.labs.brewbundle.ide.color

import co.anbora.labs.brewbundle.ide.highlight.BrewSyntaxHighlighter
import co.anbora.labs.brewbundle.ide.icons.BrewIcons
import co.anbora.labs.brewbundle.lang.BrewBundleLanguage
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class BrewBundleColorSettingPage: ColorSettingsPage {

    private val ATTRS = BrewBundleColors.values().map { it.attributesDescriptor }.toTypedArray()

    override fun getAttributeDescriptors(): Array<AttributesDescriptor> = ATTRS

    override fun getColorDescriptors(): Array<ColorDescriptor> = ColorDescriptor.EMPTY_ARRAY

    override fun getDisplayName(): String = BrewBundleLanguage.LANGUAGE_NAME

    override fun getIcon(): Icon = BrewIcons.FILE

    override fun getHighlighter(): SyntaxHighlighter = BrewSyntaxHighlighter()

    override fun getDemoText(): String = BrewBundleLanguage.LANGUAGE_DEMO_TEXT

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey> = mutableMapOf()
}