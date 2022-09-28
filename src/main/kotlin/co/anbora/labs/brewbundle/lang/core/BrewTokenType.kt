package co.anbora.labs.brewbundle.lang.core

import co.anbora.labs.brewbundle.lang.BrewBundleLanguage
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet

class BrewTokenType(debugName: String) : IElementType(debugName, BrewBundleLanguage)

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)

/*val KEYWORDS = tokenSetOf(
        RULES_VERSION, REQUEST, RESOURCE, NULL,
        IF, IN, IS,
        LET, RETURN,
        MATCH, SERVICE, FUNCTION, ALLOW
)

val RULES_PERMISSIONS = tokenSetOf(
        CREATE, DELETE, EXITS, GET, READ, UPDATE, WRITE, LIST
)

val TYPES = tokenSetOf(
        BOOL, INT, FLOAT, NUMBER, STRING, LIST, MAP, TIMESTAMP, DURATION, PATH, LATLNG
)

val FIREBASE_COMMENTS = tokenSetOf(BLOCK_COMMENT, EOL_COMMENT, EOL_DOC_COMMENT)*/
