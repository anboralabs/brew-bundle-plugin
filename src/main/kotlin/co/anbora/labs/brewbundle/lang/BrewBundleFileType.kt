package co.anbora.labs.brewbundle.lang

import co.anbora.labs.brewbundle.ide.icons.BrewIcons
import co.anbora.labs.brewbundle.lang.BrewBundleLanguage.LANGUAGE_NAME
import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

object BrewBundleFileType: LanguageFileType(BrewBundleLanguage) {
    override fun getName(): String = LANGUAGE_NAME

    override fun getDescription(): String = "Brew Bundle files"

    override fun getDefaultExtension(): String = ""

    override fun getIcon(): Icon = BrewIcons.FILE
}