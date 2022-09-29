package co.anbora.labs.brewbundle.lang

import co.anbora.labs.brewbundle.lang.core.BREW_COMMENTS
import co.anbora.labs.brewbundle.lang.core.BrewTokenType
import co.anbora.labs.brewbundle.lang.core.parser.BrewParser
import co.anbora.labs.brewbundle.lang.core.psi.BrewBundleFile
import co.anbora.labs.brewbundle.lang.core.psi.BrewTypes
import co.anbora.labs.brewbundle.lang.lexer.BrewBundleLexer
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class BrewParserDefinition: ParserDefinition {

    private val type = IFileElementType(BrewBundleLanguage)

    override fun createLexer(project: Project?): Lexer = BrewBundleLexer()

    override fun createParser(project: Project?): PsiParser = BrewParser()

    override fun getFileNodeType(): IFileElementType = type

    override fun getCommentTokens(): TokenSet = BREW_COMMENTS

    override fun getStringLiteralElements(): TokenSet = TokenSet.EMPTY

    override fun createElement(node: ASTNode?): PsiElement = BrewTypes.Factory.createElement(node)

    override fun createFile(viewProvider: FileViewProvider): PsiFile = BrewBundleFile(viewProvider)

    companion object {
        @JvmField val EOL_COMMENT = BrewTokenType("EOL_COMMENT")
        @JvmField val EOL_DOC_COMMENT = BrewTokenType("EOL_DOC_COMMENT")
    }
}