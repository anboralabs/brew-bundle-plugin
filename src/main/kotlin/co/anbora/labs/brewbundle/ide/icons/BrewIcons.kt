package co.anbora.labs.brewbundle.ide.icons

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object BrewIcons {

    val FILE = getIcon("icon_file.svg")

    private fun getIcon(path: String): Icon {
        return IconLoader.findIcon("/icons/$path", BrewIcons::class.java.classLoader) as Icon
    }
}
