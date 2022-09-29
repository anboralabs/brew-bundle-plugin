package co.anbora.labs.brewbundle.lang.core.psi

import co.anbora.labs.brewbundle.lang.BrewBundleFileType
import co.anbora.labs.brewbundle.lang.BrewBundleLanguage
import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class BrewBundleFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, BrewBundleLanguage) {

    override fun getFileType(): FileType = BrewBundleFileType

    override fun toString(): String = "Brew bundle file"

}
