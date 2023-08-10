// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package co.anbora.labs.brewbundle.lang;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static co.anbora.labs.brewbundle.lang.core.psi.BrewTypes.*;
import static co.anbora.labs.brewbundle.lang.BrewParserDefinition.*;

%%

%{
    /**
        * Dedicated storage for starting position of some previously successful
        * match
    */
    private int zzPostponedMarkedPos = -1;

    /**
        * Dedicated nested-comment level counter
    */
    private int zzNestedCommentLevel = 0;
%}

%{
  public BrewLexer() {
    this(null);
  }
%}

%public
%class BrewLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

%s IN_BLOCK_COMMENT

///////////////////////////////////////////////////////////////////////////////////////////////////
// Whitespaces
///////////////////////////////////////////////////////////////////////////////////////////////////
EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

///////////////////////////////////////////////////////////////////////////////////////////////////
// Comments
///////////////////////////////////////////////////////////////////////////////////////////////////
EOL_DOC_LINE  = {LINE_WS}*("#".*) {EOL_WS}?
LINE_COMMENT = "#"[^\r\n]* {EOL_WS}?

///////////////////////////////////////////////////////////////////////////////////////////////////
// Literals
///////////////////////////////////////////////////////////////////////////////////////////////////
BOOL_LITERAL=(true)|(false)
NUMBER_LITERAL=[0-9]+(\.[0-9]*)?
STRING_LITERAL=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")
IDENTIFIER=[a-zA-Z_\-0-9]+
ENV=:{IDENTIFIER}

%%

<YYINITIAL> {
      {EOL_WS}+            { return LINE_TERMINATOR; }
      {WHITE_SPACE}        { return WHITE_SPACE; }
      {LINE_COMMENT}       { return EOL_COMMENT; }
}

<YYINITIAL> {
    // operators
    "{"                        { return L_BRACE; }
    "}"                        { return R_BRACE; }
    "["                        { return L_BRACK; }
    "]"                        { return R_BRACK; }
    ":"                        { return COLON; }
    ","                        { return COMMA; }
    "."                        { return DOT; }
    "?"                        { return QUESTION_MARK; }
    "("                        { return L_PAREN; }
    ")"                        { return R_PAREN; }
    "\""                       { return DOUBLE_QUOTE; }
    "\'"                       { return SINGLE_QUOTE; }

    // keywords
    "tap"                      { return TAP; }
    "cask_args"                { return CASK_ARGS; }
    "brew"                     { return BREW; }
    "cask"                     { return CASK; }
    "unless"                   { return UNLESS; }
    "mas"                      { return MAS; }
    "whalebrew"                { return WHALEBREW; }

    {BOOL_LITERAL}             { return BOOL_LITERAL; }
    {NUMBER_LITERAL}           { return NUMBER_LITERAL; }
    {STRING_LITERAL}           { return STRING_LITERAL; }
    {ENV}                      { return ENVIRONMENT; }
    {IDENTIFIER}               { return IDENTIFIER; }
}

[^] { return BAD_CHARACTER; }
