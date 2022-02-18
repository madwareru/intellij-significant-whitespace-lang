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
    private static final int PARENTHESIS = 1;
    private static final int BRACKET = 2;
    private static final int NONE = 3;

    private boolean atBeginningOfTheLine = true;
    private boolean lastTokenPermitsSkipNewline = false;
    private Deque<Integer> indentStack = new ArrayDeque<Integer>();
    private int currentIndent = 0;
    private int unbalancedBraces = 0;
    private int lastUnbalancedBrace = NONE;
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
        if (!indentStack.isEmpty()) {
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
            if(zzState == IN_INDENT) {
                yybegin(IN_INDENT1);
            } else {
                yybegin(IN_INDENT);
            }
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
%s IN_INDENT1
%s IN_INDENT_STACK_ROLLBACK
%s IN_INDENT_STACK_ROLLBACK1
%s IN_FINAL

%unicode

COMMENT=[ \t\r]*"//"[^\n]*
BOOLEAN=true|false
IDENT=[A-Za-z_][A-Za-z0-9_]*
INTEGER=[+-]?([0-9][0-9]*|0x[0-9a-fA-F]+)
FLOAT=([+-]?[0-9]+\.[0-9]*([Ee][0-9]+)?)|(\.[0-9]+([Ee][0-9]+)?)
CHAR='([^\r\n\"] | (\\[\S]))'
STRING=\"([^\r\n\"]|(\\[\S]))*\"

%%

<YYINITIAL> {
    [ \t\r]*\n           {
                             if (atBeginningOfTheLine || lastTokenPermitsSkipNewline || unbalancedBraces > 0) {
                                 return WHITE_SPACE;
                             }
                             atBeginningOfTheLine = true;
                             return NEW_LINE;
                         }
    [ \t]                {if (!checkBol()) { return WHITE_SPACE; } }
    "("                  { if (!checkBol()) {
                               unbalancedBraces++;
                               lastUnbalancedBrace = PARENTHESIS;
                               lastTokenPermitsSkipNewline = false;
                               return PARENTHESISL;
                           }
                         }
    ")"                  { if (!checkBol()) {
                             unbalancedBraces--;
                             lastTokenPermitsSkipNewline = false;
                             return PARENTHESISR;
                           }
                         }
    "["                  { if (!checkBol()) {
                             unbalancedBraces++;
                             lastUnbalancedBrace = BRACKET;
                             lastTokenPermitsSkipNewline = false;
                             return BRACKETL;
                           }
                         }
    "]"                  { if (!checkBol()) {
                               unbalancedBraces--;
                               lastTokenPermitsSkipNewline = false;
                               return BRACKETR;
                           }
                         }
    ":"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return COLON; } }
    ";"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return SEMICOLON; } }
    ","                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return COMMA; } }
    "."                  { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return DOT; } }
    "and"                { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return AND; } }
    "or"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return OR; } }
    "not"                { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return NOT; } }
    "&"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return BITWISE_AND; } }
    "|"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return BITWISE_OR; } }
    "~"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return BITWISE_NOT; } }
    "^"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return BITWISE_XOR; } }
    "+"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return PLUS; } }
    "-"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return MINUS; } }
    "/"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return DIV; } }
    "%"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return MOD; } }
    "*"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return MUL; } }
    ":="                 { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return ASSIGNMENT_OP; } }
    "!="                 { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return NEQ_OP; } }
    "="                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return EQ_OP; } }
    "<"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return LT_OP; } }
    ">"                  { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return HT_OP; } }
    "<="                 { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return LTEQ_OP; } }
    ">="                 { if (!checkBol()) { lastTokenPermitsSkipNewline = true; return HTEQ_OP; } }
    "var"                { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return VAR; } }
    "let"                { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return LET; } }
    "mod"                { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return MODULE; } }
    "fn"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return FUNCTION; } }
    "proc"               { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return PROCEDURE; } }
    "if"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return IF; } }
    "elif"               { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return ELIF; } }
    "else"               { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return ELSE; } }
    "for"                { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return FOR; } }
    "to"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return TO; } }
    "while"              { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return WHILE; } }
    "as"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return AS; } }
    "record"             { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return RECORD; } }
    "array"              { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return ARRAY; } }
    "return"             { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return RETURN; } }
    "of"                 { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return OF; } }
    {COMMENT}            { return COMMENT; }
    {BOOLEAN}            { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return BOOLEAN; } }
    {IDENT}              { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return IDENT; } }
    {INTEGER}            { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return INTEGER; } }
    {FLOAT}              { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return FLOAT; } }
    {CHAR}               { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return CHAR; } }
    {STRING}             { if (!checkBol()) { lastTokenPermitsSkipNewline = false; return STRING; } }
}

<IN_INDENT, IN_INDENT1> {
    " "         { currentIndent ++; }
    \t          { currentIndent += 4; }
    [^]         { return handleIndentUnindent(); }
}

[^] { return BAD_CHARACTER; }