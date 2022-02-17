package com.github.madwareru.intellijsignificantwhitespacelang.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayDeque;import java.util.Deque;import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes.*;

%%

%{
    public PyPasLexer() {
        this((java.io.Reader)null);
    }
%}

%{
    private boolean atBeginningOfTheLine = true;
    private Deque<Integer> indentStack = new ArrayDeque<Integer>();
    private int currentIndent = 0;
%}

%{
    protected boolean stillHasWorkToDo() {
        return
            !indentStack.isEmpty();
    }

    boolean checkBol() {
        if (atBeginningOfTheLine) {
            atBeginningOfTheLine = false;
            currentIndent = 0;
            yypushback(yylength());
            yybegin(IN_INDENT);
            return true;
        }
        return false;
    }

    protected IElementType drainIndentStack() {
        if (!indentStack.isEmpty()) { // in all other cases, just roll ROLLBACK states
            indentStack.pop();
            yypushback(yylength());
            if (zzState == IN_INDENT_STACK_ROLLBACK) {
                yybegin(IN_INDENT_STACK_ROLLBACK1);
            } else  {
                yybegin(IN_INDENT_STACK_ROLLBACK);
            }
            return UNINDENT;
        }
        yybegin(IN_FINAL);
        return null;
    }

    IElementType tryIndentWithEmptyStack() {
        if (currentIndent >= 4) {
            indentStack.push(currentIndent);
            yypushback(yylength());
            yybegin(YYINITIAL);
            return INDENT;
        }
        yypushback(yylength());
        currentIndent = 0;
        yybegin(YYINITIAL);
        return WHITE_SPACE;
    }

    IElementType tryIndent(int topIndent) {
        if ((currentIndent - topIndent) >= 4) {
            indentStack.push(currentIndent);
            yypushback(yylength());
            currentIndent = 0;
            yybegin(YYINITIAL);
            return INDENT;
        }
        if ((topIndent - currentIndent) >= 4) {
            indentStack.pop();
            yypushback(yylength());
            return UNINDENT;
        }
        yypushback(yylength());
        currentIndent = 0;
        yybegin(YYINITIAL);
        return WHITE_SPACE;
    }

    IElementType handleIndentUnindent() {
        if (indentStack.isEmpty()) {
            return tryIndentWithEmptyStack();
        }
        int topIndent = indentStack.peekFirst();
        return tryIndent(topIndent);
    }
%}

%public
%class PyPasLexer
%implements FlexLexer
%function advance
%type IElementType

%s IN_INDENT
%s IN_INDENT_STACK_ROLLBACK
%s IN_INDENT_STACK_ROLLBACK1
%s IN_FINAL

%unicode

COMMENT=[ \t\r]*"//"[^\n]*
BOOLEAN=true|false
IDENT=[A-Za-z_][A-Za-z0-9_]*
INTEGER=[+-]?[0-9][0-9_]*
FLOAT=([+-]?[0-9]+\.[0-9]*([Ee][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
CHAR='([^\r\n\"] | (\\[\S]))'
STRING=\"([^\r\n\"]|(\\[\S]))*\"

%%

<YYINITIAL> {
    [ \t\r]*\n           {
                             if (atBeginningOfTheLine) {
                                 return WHITE_SPACE;
                             }
                             atBeginningOfTheLine = true;
                             return NEW_LINE;
                         }
    [ \t]                {if (!checkBol()) { return WHITE_SPACE; } }
    "("                  { if (!checkBol()) { return PARENTHESISL; } }
    ")"                  { if (!checkBol()) { return PARENTHESISR; } }
    "["                  { if (!checkBol()) { return BRACKETL; } }
    "]"                  { if (!checkBol()) { return BRACKETR; } }
    "{"                  { if (!checkBol()) { return BRACEL; } }
    "}"                  { if (!checkBol()) { return BRACER; } }
    ":"                  { if (!checkBol()) { return COLON; } }
    ";"                  { if (!checkBol()) { return SEMICOLON; } }
    ","                  { if (!checkBol()) { return COMMA; } }
    "."                  { if (!checkBol()) { return DOT; } }
    "and"                { if (!checkBol()) { return AND; } }
    "or"                 { if (!checkBol()) { return OR; } }
    "not"                { if (!checkBol()) { return NOT; } }
    "&"                  { if (!checkBol()) { return BITWISE_AND; } }
    "|"                  { if (!checkBol()) { return BITWISE_OR; } }
    "~"                  { if (!checkBol()) { return BITWISE_NOT; } }
    "^"                  { if (!checkBol()) { return BITWISE_XOR; } }
    "+"                  { if (!checkBol()) { return PLUS; } }
    "-"                  { if (!checkBol()) { return MINUS; } }
    "/"                  { if (!checkBol()) { return DIV; } }
    "%"                  { if (!checkBol()) { return MOD; } }
    "*"                  { if (!checkBol()) { return MUL; } }
    ":="                 { if (!checkBol()) { return ASSIGNMENT_OP; } }
    "!="                 { if (!checkBol()) { return NEQ_OP; } }
    "="                  { if (!checkBol()) { return EQ_OP; } }
    "<"                  { if (!checkBol()) { return LT_OP; } }
    ">"                  { if (!checkBol()) { return HT_OP; } }
    "<="                 { if (!checkBol()) { return LTEQ_OP; } }
    ">="                 { if (!checkBol()) { return HTEQ_OP; } }
    "var"                { if (!checkBol()) { return VAR; } }
    "program"            { if (!checkBol()) { return PROGRAM; } }
    "module"             { if (!checkBol()) { return MODULE; } }
    "function"           { if (!checkBol()) { return FUNCTION; } }
    "procedure"          { if (!checkBol()) { return PROCEDURE; } }
    "if"                 { if (!checkBol()) { return IF; } }
    "elif"               { if (!checkBol()) { return ELIF; } }
    "else"               { if (!checkBol()) { return ELSE; } }
    "for"                { if (!checkBol()) { return FOR; } }
    "to"                 { if (!checkBol()) { return TO; } }
    "while"              { if (!checkBol()) { return WHILE; } }
    "as"                 { if (!checkBol()) { return AS; } }
    "record"             { if (!checkBol()) { return RECORD; } }
    "array"              { if (!checkBol()) { return ARRAY; } }
    "return"             { if (!checkBol()) { return RETURN; } }
    "of"                 { if (!checkBol()) { return OF; } }
    "end"                { if (!checkBol()) { return END; } }
    {COMMENT}            { return COMMENT; }
    {BOOLEAN}            { if (!checkBol()) { return BOOLEAN; } }
    {IDENT}              { if (!checkBol()) { return IDENT; } }
    {INTEGER}            { if (!checkBol()) { return INTEGER; } }
    {FLOAT}              { if (!checkBol()) { return FLOAT; } }
    {CHAR}               { if (!checkBol()) { return CHAR; } }
    {STRING}             { if (!checkBol()) { return STRING; } }
}

<IN_INDENT> {
    " "         { currentIndent ++; }
    \t          { currentIndent += 4; }
    [^]         { return handleIndentUnindent(); }
}

[^] { return BAD_CHARACTER; }