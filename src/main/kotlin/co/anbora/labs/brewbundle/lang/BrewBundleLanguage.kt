package co.anbora.labs.brewbundle.lang

import com.intellij.lang.Language
import com.intellij.openapi.util.io.StreamUtil

object BrewBundleLanguage: Language("brew_bundle") {

    const val LANGUAGE_NAME = "Brew Bundle"

    val LANGUAGE_DEMO_TEXT by lazy {
        val stream = javaClass.classLoader.getResourceAsStream("demo/Brewfile")
            ?: error("No such file")
        val text = stream.bufferedReader().use { it.readText() }
        StreamUtil.convertSeparators(text)
    }
}