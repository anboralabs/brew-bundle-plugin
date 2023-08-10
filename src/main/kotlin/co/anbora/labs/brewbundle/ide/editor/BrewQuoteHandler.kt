package co.anbora.labs.brewbundle.ide.editor

import com.intellij.codeInsight.editorActions.SimpleTokenSetQuoteHandler
import co.anbora.labs.brewbundle.lang.core.psi.BrewTypes.*


class BrewQuoteHandler: SimpleTokenSetQuoteHandler(SINGLE_QUOTE, DOUBLE_QUOTE)