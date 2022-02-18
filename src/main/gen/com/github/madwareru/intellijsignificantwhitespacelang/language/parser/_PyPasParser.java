// This is a generated file. Not intended for manual editing.
package com.github.madwareru.intellijsignificantwhitespacelang.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes.*;
import static com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class _PyPasParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return PyPas(b, l + 1);
  }

  /* ********************************************************** */
  // program_header definitions
  static boolean PyPas(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PyPas")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_header(b, l + 1);
    r = r && definitions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT COLON type_definition [EQ_OP operator_expr]
  public static boolean arg_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && type_definition(b, l + 1);
    r = r && arg_definition_3(b, l + 1);
    exit_section_(b, m, ARG_DEFINITION, r);
    return r;
  }

  // [EQ_OP operator_expr]
  private static boolean arg_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_definition_3")) return false;
    arg_definition_3_0(b, l + 1);
    return true;
  }

  // EQ_OP operator_expr
  private static boolean arg_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_definition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EQ_OP);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // arg_definition (COMMA arg_definition)*
  public static boolean arg_defs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = arg_definition(b, l + 1);
    r = r && arg_defs_1(b, l + 1);
    exit_section_(b, m, ARG_DEFS, r);
    return r;
  }

  // (COMMA arg_definition)*
  private static boolean arg_defs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_defs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_defs_1", c)) break;
    }
    return true;
  }

  // COMMA arg_definition
  private static boolean arg_defs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && arg_definition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // operator_expr (COMMA operator_expr)*
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS, "<args>");
    r = operator_expr(b, l + 1);
    r = r && args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA operator_expr)*
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_1", c)) break;
    }
    return true;
  }

  // COMMA operator_expr
  private static boolean args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ARRAY BRACKETL INTEGER TO INTEGER BRACKETR OF IDENT
  public static boolean array_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "array_type_definition")) return false;
    if (!nextTokenIs(b, ARRAY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ARRAY, BRACKETL, INTEGER, TO, INTEGER, BRACKETR, OF, IDENT);
    exit_section_(b, m, ARRAY_TYPE_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // lvalue ASSIGNMENT_OP operator_expr
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT_OP);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // COLON NEW_LINE INDENT [statements] UNINDENT
  public static boolean block_statements_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_statements_body")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, NEW_LINE, INDENT);
    r = r && block_statements_body_3(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, BLOCK_STATEMENTS_BODY, r);
    return r;
  }

  // [statements]
  private static boolean block_statements_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_statements_body_3")) return false;
    statements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BOOLEAN | INTEGER | FLOAT | STRING
  public static boolean constant_literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant_literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT_LITERAL, "<constant literal>");
    r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // proc_define | func_define | record_define
  public static boolean definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DEFINITION, "<definition>");
    r = proc_define(b, l + 1);
    if (!r) r = func_define(b, l + 1);
    if (!r) r = record_define(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // COLON NEW_LINE INDENT definition+ UNINDENT
  public static boolean definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definitions")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, NEW_LINE, INDENT);
    r = r && definitions_3(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, DEFINITIONS, r);
    return r;
  }

  // definition+
  private static boolean definitions_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definitions_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = definition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "definitions_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PLUS | MINUS | MUL | DIV | MOD | BITWISE_NOT | BITWISE_OR | BITWISE_XOR | BITWISE_AND
  //     | LT_OP | LTEQ_OP | HT_OP | HTEQ_OP | EQ_OP | NEQ_OP | NOT | OR | AND
  public static boolean e_operator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "e_operator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, E_OPERATOR, "<e operator>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, BITWISE_NOT);
    if (!r) r = consumeToken(b, BITWISE_OR);
    if (!r) r = consumeToken(b, BITWISE_XOR);
    if (!r) r = consumeToken(b, BITWISE_AND);
    if (!r) r = consumeToken(b, LT_OP);
    if (!r) r = consumeToken(b, LTEQ_OP);
    if (!r) r = consumeToken(b, HT_OP);
    if (!r) r = consumeToken(b, HTEQ_OP);
    if (!r) r = consumeToken(b, EQ_OP);
    if (!r) r = consumeToken(b, NEQ_OP);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR IDENT ASSIGNMENT_OP constant_literal to constant_literal block_statements_body
  public static boolean for_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "for_statement")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENT, ASSIGNMENT_OP);
    r = r && constant_literal(b, l + 1);
    r = r && consumeToken(b, TO);
    r = r && constant_literal(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, FOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // FUNCTION IDENT PARENTHESISL [arg_defs] PARENTHESISR MINUS HT_OP IDENT block_statements_body
  public static boolean func_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_define")) return false;
    if (!nextTokenIs(b, FUNCTION)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FUNCTION, IDENT, PARENTHESISL);
    r = r && func_define_3(b, l + 1);
    r = r && consumeTokens(b, 0, PARENTHESISR, MINUS, HT_OP, IDENT);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, FUNC_DEFINE, r);
    return r;
  }

  // [arg_defs]
  private static boolean func_define_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "func_define_3")) return false;
    arg_defs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENT PARENTHESISL [args] PARENTHESISR
  public static boolean function_invocation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_invocation")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, PARENTHESISL);
    r = r && function_invocation_2(b, l + 1);
    r = r && consumeToken(b, PARENTHESISR);
    exit_section_(b, m, FUNCTION_INVOCATION, r);
    return r;
  }

  // [args]
  private static boolean function_invocation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function_invocation_2")) return false;
    args(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IF operator_expr block_statements_body
  //     (ELIF operator_expr block_statements_body)*
  //     (ELSE block_statements_body)?
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && operator_expr(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    r = r && if_statement_3(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // (ELIF operator_expr block_statements_body)*
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_statement_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_3", c)) break;
    }
    return true;
  }

  // ELIF operator_expr block_statements_body
  private static boolean if_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && operator_expr(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ELSE block_statements_body)?
  private static boolean if_statement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4")) return false;
    if_statement_4_0(b, l + 1);
    return true;
  }

  // ELSE block_statements_body
  private static boolean if_statement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT (BRACKETL operator_expr BRACKETR)+
  public static boolean indexed_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexed_access")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && indexed_access_1(b, l + 1);
    exit_section_(b, m, INDEXED_ACCESS, r);
    return r;
  }

  // (BRACKETL operator_expr BRACKETR)+
  private static boolean indexed_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexed_access_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = indexed_access_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!indexed_access_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "indexed_access_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // BRACKETL operator_expr BRACKETR
  private static boolean indexed_access_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexed_access_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKETL);
    r = r && operator_expr(b, l + 1);
    r = r && consumeToken(b, BRACKETR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT COLON type_definition ASSIGNMENT_OP operator_expr
  public static boolean let_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && type_definition(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT_OP);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, LET_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // (let_definition NEW_LINE)+
  public static boolean let_definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definitions")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_definitions_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!let_definitions_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_definitions", c)) break;
    }
    exit_section_(b, m, LET_DEFINITIONS, r);
    return r;
  }

  // let_definition NEW_LINE
  private static boolean let_definitions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definitions_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_definition(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // let_definition (COMMA let_definition)*
  public static boolean let_definitions_single_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definitions_single_line")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = let_definition(b, l + 1);
    r = r && let_definitions_single_line_1(b, l + 1);
    exit_section_(b, m, LET_DEFINITIONS_SINGLE_LINE, r);
    return r;
  }

  // (COMMA let_definition)*
  private static boolean let_definitions_single_line_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definitions_single_line_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!let_definitions_single_line_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "let_definitions_single_line_1", c)) break;
    }
    return true;
  }

  // COMMA let_definition
  private static boolean let_definitions_single_line_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_definitions_single_line_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && let_definition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LET NEW_LINE INDENT let_definitions UNINDENT
  public static boolean let_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LET, NEW_LINE, INDENT);
    r = r && let_definitions(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, LET_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // LET let_definitions_single_line
  public static boolean let_statement_single_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "let_statement_single_line")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && let_definitions_single_line(b, l + 1);
    exit_section_(b, m, LET_STATEMENT_SINGLE_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // subfield_access | indexed_access | IDENT
  public static boolean lvalue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lvalue")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subfield_access(b, l + 1);
    if (!r) r = indexed_access(b, l + 1);
    if (!r) r = consumeToken(b, IDENT);
    exit_section_(b, m, LVALUE, r);
    return r;
  }

  /* ********************************************************** */
  // term_expr (e_operator operator_expr)*
  public static boolean operator_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATOR_EXPR, "<operator expr>");
    r = term_expr(b, l + 1);
    r = r && operator_expr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (e_operator operator_expr)*
  private static boolean operator_expr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator_expr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!operator_expr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "operator_expr_1", c)) break;
    }
    return true;
  }

  // e_operator operator_expr
  private static boolean operator_expr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "operator_expr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = e_operator(b, l + 1);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PROCEDURE IDENT PARENTHESISL [arg_defs] PARENTHESISR block_statements_body
  public static boolean proc_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc_define")) return false;
    if (!nextTokenIs(b, PROCEDURE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PROCEDURE, IDENT, PARENTHESISL);
    r = r && proc_define_3(b, l + 1);
    r = r && consumeToken(b, PARENTHESISR);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, PROC_DEFINE, r);
    return r;
  }

  // [arg_defs]
  private static boolean proc_define_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proc_define_3")) return false;
    arg_defs(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MODULE IDENT
  public static boolean program_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_header")) return false;
    if (!nextTokenIs(b, MODULE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MODULE, IDENT);
    exit_section_(b, m, PROGRAM_HEADER, r);
    return r;
  }

  /* ********************************************************** */
  // COLON NEW_LINE INDENT var_definitions UNINDENT
  public static boolean record_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_body")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, NEW_LINE, INDENT);
    r = r && var_definitions(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, RECORD_BODY, r);
    return r;
  }

  /* ********************************************************** */
  // RECORD IDENT record_body
  public static boolean record_define(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_define")) return false;
    if (!nextTokenIs(b, RECORD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, RECORD, IDENT);
    r = r && record_body(b, l + 1);
    exit_section_(b, m, RECORD_DEFINE, r);
    return r;
  }

  /* ********************************************************** */
  // RETURN operator_expr
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, RETURN_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean simple_type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "simple_type_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, SIMPLE_TYPE_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // assignment_statement | function_invocation | return_statement | var_statement_single_line | let_statement_single_line
  public static boolean single_line_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "single_line_statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SINGLE_LINE_STATEMENT, "<single line statement>");
    r = assignment_statement(b, l + 1);
    if (!r) r = function_invocation(b, l + 1);
    if (!r) r = return_statement(b, l + 1);
    if (!r) r = var_statement_single_line(b, l + 1);
    if (!r) r = let_statement_single_line(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (single_line_statement (SEMICOLON single_line_statement)* NEW_LINE)
  //     | if_statement
  //     | for_statement
  //     | while_statement
  //     | var_statement
  //     | let_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = statement_0(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    if (!r) r = var_statement(b, l + 1);
    if (!r) r = let_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // single_line_statement (SEMICOLON single_line_statement)* NEW_LINE
  private static boolean statement_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = single_line_statement(b, l + 1);
    r = r && statement_0_1(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SEMICOLON single_line_statement)*
  private static boolean statement_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!statement_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statement_0_1", c)) break;
    }
    return true;
  }

  // SEMICOLON single_line_statement
  private static boolean statement_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SEMICOLON);
    r = r && single_line_statement(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // statement+
  public static boolean statements(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statements")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENTS, "<statements>");
    r = statement(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "statements", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENT (DOT IDENT)+
  public static boolean subfield_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subfield_access")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    r = r && subfield_access_1(b, l + 1);
    exit_section_(b, m, SUBFIELD_ACCESS, r);
    return r;
  }

  // (DOT IDENT)+
  private static boolean subfield_access_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subfield_access_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = subfield_access_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!subfield_access_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "subfield_access_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT IDENT
  private static boolean subfield_access_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "subfield_access_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (PARENTHESISL operator_expr PARENTHESISR)
  //     | function_invocation
  //     | indexed_access
  //     | subfield_access
  //     | constant_literal
  //     | variable_access
  public static boolean term_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERM_EXPR, "<term expr>");
    r = term_expr_0(b, l + 1);
    if (!r) r = function_invocation(b, l + 1);
    if (!r) r = indexed_access(b, l + 1);
    if (!r) r = subfield_access(b, l + 1);
    if (!r) r = constant_literal(b, l + 1);
    if (!r) r = variable_access(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PARENTHESISL operator_expr PARENTHESISR
  private static boolean term_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESISL);
    r = r && operator_expr(b, l + 1);
    r = r && consumeToken(b, PARENTHESISR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // simple_type_definition | array_type_definition
  public static boolean type_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "type_definition")) return false;
    if (!nextTokenIs(b, "<type definition>", ARRAY, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_DEFINITION, "<type definition>");
    r = simple_type_definition(b, l + 1);
    if (!r) r = array_type_definition(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENT COLON type_definition [ASSIGNMENT_OP operator_expr]
  public static boolean var_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && type_definition(b, l + 1);
    r = r && var_definition_3(b, l + 1);
    exit_section_(b, m, VAR_DEFINITION, r);
    return r;
  }

  // [ASSIGNMENT_OP operator_expr]
  private static boolean var_definition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition_3")) return false;
    var_definition_3_0(b, l + 1);
    return true;
  }

  // ASSIGNMENT_OP operator_expr
  private static boolean var_definition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT_OP);
    r = r && operator_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (var_definition NEW_LINE)+
  public static boolean var_definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_definitions_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!var_definitions_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_definitions", c)) break;
    }
    exit_section_(b, m, VAR_DEFINITIONS, r);
    return r;
  }

  // var_definition NEW_LINE
  private static boolean var_definitions_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_definition(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_definition (COMMA var_definition)*
  public static boolean var_definitions_single_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions_single_line")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_definition(b, l + 1);
    r = r && var_definitions_single_line_1(b, l + 1);
    exit_section_(b, m, VAR_DEFINITIONS_SINGLE_LINE, r);
    return r;
  }

  // (COMMA var_definition)*
  private static boolean var_definitions_single_line_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions_single_line_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!var_definitions_single_line_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_definitions_single_line_1", c)) break;
    }
    return true;
  }

  // COMMA var_definition
  private static boolean var_definitions_single_line_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions_single_line_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var_definition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR NEW_LINE INDENT var_definitions UNINDENT
  public static boolean var_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VAR, NEW_LINE, INDENT);
    r = r && var_definitions(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, VAR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // VAR var_definitions_single_line
  public static boolean var_statement_single_line(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_statement_single_line")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    r = r && var_definitions_single_line(b, l + 1);
    exit_section_(b, m, VAR_STATEMENT_SINGLE_LINE, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT
  public static boolean variable_access(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_access")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENT);
    exit_section_(b, m, VARIABLE_ACCESS, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE operator_expr block_statements_body
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && operator_expr(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

}
