// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.madwareru.intellijsignificantwhitespacelang.language.psi.impl.*;

public interface PyPasTypes {

  IElementType ARGS = new PyPasElementType("ARGS");
  IElementType ARG_DEFINITION = new PyPasElementType("ARG_DEFINITION");
  IElementType ARG_DEFS = new PyPasElementType("ARG_DEFS");
  IElementType ARRAY_TYPE_DEFINITION = new PyPasElementType("ARRAY_TYPE_DEFINITION");
  IElementType ASSIGNMENT_STATEMENT = new PyPasElementType("ASSIGNMENT_STATEMENT");
  IElementType BLOCK_STATEMENTS_BODY = new PyPasElementType("BLOCK_STATEMENTS_BODY");
  IElementType CONSTANT_LITERAL = new PyPasElementType("CONSTANT_LITERAL");
  IElementType DEFINITION = new PyPasElementType("DEFINITION");
  IElementType DEFINITIONS = new PyPasElementType("DEFINITIONS");
  IElementType E_OPERATOR = new PyPasElementType("E_OPERATOR");
  IElementType FOR_STATEMENT = new PyPasElementType("FOR_STATEMENT");
  IElementType FUNCTION_INVOCATION = new PyPasElementType("FUNCTION_INVOCATION");
  IElementType FUNC_DEFINE = new PyPasElementType("FUNC_DEFINE");
  IElementType IF_STATEMENT = new PyPasElementType("IF_STATEMENT");
  IElementType INDEXED_ACCESS = new PyPasElementType("INDEXED_ACCESS");
  IElementType LET_DEFINITION = new PyPasElementType("LET_DEFINITION");
  IElementType LET_DEFINITIONS = new PyPasElementType("LET_DEFINITIONS");
  IElementType LET_DEFINITIONS_SINGLE_LINE = new PyPasElementType("LET_DEFINITIONS_SINGLE_LINE");
  IElementType LET_STATEMENT = new PyPasElementType("LET_STATEMENT");
  IElementType LET_STATEMENT_SINGLE_LINE = new PyPasElementType("LET_STATEMENT_SINGLE_LINE");
  IElementType LVALUE = new PyPasElementType("LVALUE");
  IElementType OPERATOR_EXPR = new PyPasElementType("OPERATOR_EXPR");
  IElementType PROC_DEFINE = new PyPasElementType("PROC_DEFINE");
  IElementType PROGRAM_HEADER = new PyPasElementType("PROGRAM_HEADER");
  IElementType RECORD_BODY = new PyPasElementType("RECORD_BODY");
  IElementType RECORD_DEFINE = new PyPasElementType("RECORD_DEFINE");
  IElementType RETURN_STATEMENT = new PyPasElementType("RETURN_STATEMENT");
  IElementType SIMPLE_TYPE_DEFINITION = new PyPasElementType("SIMPLE_TYPE_DEFINITION");
  IElementType SINGLE_LINE_STATEMENT = new PyPasElementType("SINGLE_LINE_STATEMENT");
  IElementType STATEMENT = new PyPasElementType("STATEMENT");
  IElementType STATEMENTS = new PyPasElementType("STATEMENTS");
  IElementType SUBFIELD_ACCESS = new PyPasElementType("SUBFIELD_ACCESS");
  IElementType TERM_EXPR = new PyPasElementType("TERM_EXPR");
  IElementType TYPE_DEFINITION = new PyPasElementType("TYPE_DEFINITION");
  IElementType VARIABLE_ACCESS = new PyPasElementType("VARIABLE_ACCESS");
  IElementType VAR_DEFINITION = new PyPasElementType("VAR_DEFINITION");
  IElementType VAR_DEFINITIONS = new PyPasElementType("VAR_DEFINITIONS");
  IElementType VAR_DEFINITIONS_SINGLE_LINE = new PyPasElementType("VAR_DEFINITIONS_SINGLE_LINE");
  IElementType VAR_STATEMENT = new PyPasElementType("VAR_STATEMENT");
  IElementType VAR_STATEMENT_SINGLE_LINE = new PyPasElementType("VAR_STATEMENT_SINGLE_LINE");
  IElementType WHILE_STATEMENT = new PyPasElementType("WHILE_STATEMENT");

  IElementType AND = new PyPasTokenType("and");
  IElementType ARRAY = new PyPasTokenType("array");
  IElementType AS = new PyPasTokenType("as");
  IElementType ASSIGNMENT_OP = new PyPasTokenType(":=");
  IElementType BITWISE_AND = new PyPasTokenType("&");
  IElementType BITWISE_NOT = new PyPasTokenType("~");
  IElementType BITWISE_OR = new PyPasTokenType("|");
  IElementType BITWISE_XOR = new PyPasTokenType("^");
  IElementType BOOLEAN = new PyPasTokenType("BOOLEAN");
  IElementType BRACEL = new PyPasTokenType("{");
  IElementType BRACER = new PyPasTokenType("}");
  IElementType BRACKETL = new PyPasTokenType("[");
  IElementType BRACKETR = new PyPasTokenType("]");
  IElementType CHAR = new PyPasTokenType("CHAR");
  IElementType COLON = new PyPasTokenType(":");
  IElementType COMMA = new PyPasTokenType(",");
  IElementType COMMENT = new PyPasTokenType("COMMENT");
  IElementType DIV = new PyPasTokenType("/");
  IElementType DOT = new PyPasTokenType(".");
  IElementType ELIF = new PyPasTokenType("elif");
  IElementType ELSE = new PyPasTokenType("else");
  IElementType EQ_OP = new PyPasTokenType("=");
  IElementType FLOAT = new PyPasTokenType("FLOAT");
  IElementType FOR = new PyPasTokenType("for");
  IElementType FUNCTION = new PyPasTokenType("fn");
  IElementType HTEQ_OP = new PyPasTokenType(">=");
  IElementType HT_OP = new PyPasTokenType(">");
  IElementType IDENT = new PyPasTokenType("IDENT");
  IElementType IF = new PyPasTokenType("if");
  IElementType INDENT = new PyPasTokenType("INDENT");
  IElementType INTEGER = new PyPasTokenType("INTEGER");
  IElementType LET = new PyPasTokenType("let");
  IElementType LTEQ_OP = new PyPasTokenType("<=");
  IElementType LT_OP = new PyPasTokenType("<");
  IElementType MINUS = new PyPasTokenType("-");
  IElementType MOD = new PyPasTokenType("%");
  IElementType MODULE = new PyPasTokenType("mod");
  IElementType MUL = new PyPasTokenType("*");
  IElementType NEQ_OP = new PyPasTokenType("!=");
  IElementType NEW_LINE = new PyPasTokenType("NEW_LINE");
  IElementType NOT = new PyPasTokenType("not");
  IElementType OF = new PyPasTokenType("of");
  IElementType OR = new PyPasTokenType("or");
  IElementType PARENTHESISL = new PyPasTokenType("(");
  IElementType PARENTHESISR = new PyPasTokenType(")");
  IElementType PLUS = new PyPasTokenType("+");
  IElementType PROCEDURE = new PyPasTokenType("proc");
  IElementType RECORD = new PyPasTokenType("record");
  IElementType RETURN = new PyPasTokenType("return");
  IElementType SEMICOLON = new PyPasTokenType(";");
  IElementType STRING = new PyPasTokenType("STRING");
  IElementType TO = new PyPasTokenType("to");
  IElementType TYPE = new PyPasTokenType("type");
  IElementType UNINDENT = new PyPasTokenType("UNINDENT");
  IElementType VAR = new PyPasTokenType("var");
  IElementType WHILE = new PyPasTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGS) {
        return new PyPasArgsImpl(node);
      }
      else if (type == ARG_DEFINITION) {
        return new PyPasArgDefinitionImpl(node);
      }
      else if (type == ARG_DEFS) {
        return new PyPasArgDefsImpl(node);
      }
      else if (type == ARRAY_TYPE_DEFINITION) {
        return new PyPasArrayTypeDefinitionImpl(node);
      }
      else if (type == ASSIGNMENT_STATEMENT) {
        return new PyPasAssignmentStatementImpl(node);
      }
      else if (type == BLOCK_STATEMENTS_BODY) {
        return new PyPasBlockStatementsBodyImpl(node);
      }
      else if (type == CONSTANT_LITERAL) {
        return new PyPasConstantLiteralImpl(node);
      }
      else if (type == DEFINITION) {
        return new PyPasDefinitionImpl(node);
      }
      else if (type == DEFINITIONS) {
        return new PyPasDefinitionsImpl(node);
      }
      else if (type == E_OPERATOR) {
        return new PyPasEOperatorImpl(node);
      }
      else if (type == FOR_STATEMENT) {
        return new PyPasForStatementImpl(node);
      }
      else if (type == FUNCTION_INVOCATION) {
        return new PyPasFunctionInvocationImpl(node);
      }
      else if (type == FUNC_DEFINE) {
        return new PyPasFuncDefineImpl(node);
      }
      else if (type == IF_STATEMENT) {
        return new PyPasIfStatementImpl(node);
      }
      else if (type == INDEXED_ACCESS) {
        return new PyPasIndexedAccessImpl(node);
      }
      else if (type == LET_DEFINITION) {
        return new PyPasLetDefinitionImpl(node);
      }
      else if (type == LET_DEFINITIONS) {
        return new PyPasLetDefinitionsImpl(node);
      }
      else if (type == LET_DEFINITIONS_SINGLE_LINE) {
        return new PyPasLetDefinitionsSingleLineImpl(node);
      }
      else if (type == LET_STATEMENT) {
        return new PyPasLetStatementImpl(node);
      }
      else if (type == LET_STATEMENT_SINGLE_LINE) {
        return new PyPasLetStatementSingleLineImpl(node);
      }
      else if (type == LVALUE) {
        return new PyPasLvalueImpl(node);
      }
      else if (type == OPERATOR_EXPR) {
        return new PyPasOperatorExprImpl(node);
      }
      else if (type == PROC_DEFINE) {
        return new PyPasProcDefineImpl(node);
      }
      else if (type == PROGRAM_HEADER) {
        return new PyPasProgramHeaderImpl(node);
      }
      else if (type == RECORD_BODY) {
        return new PyPasRecordBodyImpl(node);
      }
      else if (type == RECORD_DEFINE) {
        return new PyPasRecordDefineImpl(node);
      }
      else if (type == RETURN_STATEMENT) {
        return new PyPasReturnStatementImpl(node);
      }
      else if (type == SIMPLE_TYPE_DEFINITION) {
        return new PyPasSimpleTypeDefinitionImpl(node);
      }
      else if (type == SINGLE_LINE_STATEMENT) {
        return new PyPasSingleLineStatementImpl(node);
      }
      else if (type == STATEMENT) {
        return new PyPasStatementImpl(node);
      }
      else if (type == STATEMENTS) {
        return new PyPasStatementsImpl(node);
      }
      else if (type == SUBFIELD_ACCESS) {
        return new PyPasSubfieldAccessImpl(node);
      }
      else if (type == TERM_EXPR) {
        return new PyPasTermExprImpl(node);
      }
      else if (type == TYPE_DEFINITION) {
        return new PyPasTypeDefinitionImpl(node);
      }
      else if (type == VARIABLE_ACCESS) {
        return new PyPasVariableAccessImpl(node);
      }
      else if (type == VAR_DEFINITION) {
        return new PyPasVarDefinitionImpl(node);
      }
      else if (type == VAR_DEFINITIONS) {
        return new PyPasVarDefinitionsImpl(node);
      }
      else if (type == VAR_DEFINITIONS_SINGLE_LINE) {
        return new PyPasVarDefinitionsSingleLineImpl(node);
      }
      else if (type == VAR_STATEMENT) {
        return new PyPasVarStatementImpl(node);
      }
      else if (type == VAR_STATEMENT_SINGLE_LINE) {
        return new PyPasVarStatementSingleLineImpl(node);
      }
      else if (type == WHILE_STATEMENT) {
        return new PyPasWhileStatementImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
