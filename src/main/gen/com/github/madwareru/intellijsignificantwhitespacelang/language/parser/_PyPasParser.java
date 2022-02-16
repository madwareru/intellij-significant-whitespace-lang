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
    if (!nextTokenIs(b, "", MODULE, PROGRAM)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = program_header(b, l + 1);
    r = r && definitions(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var_definition (COMMA var_definition)*
  public static boolean arg_defs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_definition(b, l + 1);
    r = r && arg_defs_1(b, l + 1);
    exit_section_(b, m, ARG_DEFS, r);
    return r;
  }

  // (COMMA var_definition)*
  private static boolean arg_defs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!arg_defs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "arg_defs_1", c)) break;
    }
    return true;
  }

  // COMMA var_definition
  private static boolean arg_defs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arg_defs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var_definition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logic_and_expr (COMMA logic_and_expr)*
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS, "<args>");
    r = logic_and_expr(b, l + 1);
    r = r && args_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA logic_and_expr)*
  private static boolean args_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!args_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "args_1", c)) break;
    }
    return true;
  }

  // COMMA logic_and_expr
  private static boolean args_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && logic_and_expr(b, l + 1);
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
  // lvalue ASSIGNMENT_OP logic_and_expr
  public static boolean assignment_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignment_statement")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = lvalue(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT_OP);
    r = r && logic_and_expr(b, l + 1);
    exit_section_(b, m, ASSIGNMENT_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // bit_or_xor_expr BITWISE_AND bit_or_xor_expr | bit_or_xor_expr
  public static boolean bit_and_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_and_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_AND_EXPR, "<bit and expr>");
    r = bit_and_expr_0(b, l + 1);
    if (!r) r = bit_or_xor_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bit_or_xor_expr BITWISE_AND bit_or_xor_expr
  private static boolean bit_and_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_and_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bit_or_xor_expr(b, l + 1);
    r = r && consumeToken(b, BITWISE_AND);
    r = r && bit_or_xor_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BITWISE_NOT mul_div_expr | mul_div_expr
  public static boolean bit_not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_not_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_NOT_EXPR, "<bit not expr>");
    r = bit_not_expr_0(b, l + 1);
    if (!r) r = mul_div_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BITWISE_NOT mul_div_expr
  private static boolean bit_not_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_not_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_NOT);
    r = r && mul_div_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bit_not_expr (BITWISE_OR | BITWISE_XOR) bit_not_expr | bit_not_expr
  public static boolean bit_or_xor_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_or_xor_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BIT_OR_XOR_EXPR, "<bit or xor expr>");
    r = bit_or_xor_expr_0(b, l + 1);
    if (!r) r = bit_not_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bit_not_expr (BITWISE_OR | BITWISE_XOR) bit_not_expr
  private static boolean bit_or_xor_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_or_xor_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bit_not_expr(b, l + 1);
    r = r && bit_or_xor_expr_0_1(b, l + 1);
    r = r && bit_not_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // BITWISE_OR | BITWISE_XOR
  private static boolean bit_or_xor_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bit_or_xor_expr_0_1")) return false;
    boolean r;
    r = consumeToken(b, BITWISE_OR);
    if (!r) r = consumeToken(b, BITWISE_XOR);
    return r;
  }

  /* ********************************************************** */
  // COLON INDENT [var_block] [statements] UNINDENT
  public static boolean block_statements_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_statements_body")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, INDENT);
    r = r && block_statements_body_2(b, l + 1);
    r = r && block_statements_body_3(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, BLOCK_STATEMENTS_BODY, r);
    return r;
  }

  // [var_block]
  private static boolean block_statements_body_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_statements_body_2")) return false;
    var_block(b, l + 1);
    return true;
  }

  // [statements]
  private static boolean block_statements_body_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "block_statements_body_3")) return false;
    statements(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // bit_and_expr (LT_OP | LTEQ_OP | HT_OP | HTEQ_OP | EQ_OP | NEQ_OP ) bit_and_expr | bit_and_expr
  public static boolean compare_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compare_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPARE_EXPR, "<compare expr>");
    r = compare_expr_0(b, l + 1);
    if (!r) r = bit_and_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // bit_and_expr (LT_OP | LTEQ_OP | HT_OP | HTEQ_OP | EQ_OP | NEQ_OP ) bit_and_expr
  private static boolean compare_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compare_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = bit_and_expr(b, l + 1);
    r = r && compare_expr_0_1(b, l + 1);
    r = r && bit_and_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LT_OP | LTEQ_OP | HT_OP | HTEQ_OP | EQ_OP | NEQ_OP
  private static boolean compare_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compare_expr_0_1")) return false;
    boolean r;
    r = consumeToken(b, LT_OP);
    if (!r) r = consumeToken(b, LTEQ_OP);
    if (!r) r = consumeToken(b, HT_OP);
    if (!r) r = consumeToken(b, HTEQ_OP);
    if (!r) r = consumeToken(b, EQ_OP);
    if (!r) r = consumeToken(b, NEQ_OP);
    return r;
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
  // COLON INDENT definition+ UNINDENT DOT
  public static boolean definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definitions")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, INDENT);
    r = r && definitions_2(b, l + 1);
    r = r && consumeTokens(b, 0, UNINDENT, DOT);
    exit_section_(b, m, DEFINITIONS, r);
    return r;
  }

  // definition+
  private static boolean definitions_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "definitions_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = definition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "definitions_2", c)) break;
    }
    exit_section_(b, m, null, r);
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
  // IF logic_and_expr block_statements_body
  //     (ELIF logic_and_expr block_statements_body)*
  //     (ELSE block_statements_body)?
  public static boolean if_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && logic_and_expr(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    r = r && if_statement_3(b, l + 1);
    r = r && if_statement_4(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // (ELIF logic_and_expr block_statements_body)*
  private static boolean if_statement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!if_statement_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "if_statement_3", c)) break;
    }
    return true;
  }

  // ELIF logic_and_expr block_statements_body
  private static boolean if_statement_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "if_statement_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELIF);
    r = r && logic_and_expr(b, l + 1);
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
  // IDENT (BRACKETL logic_and_expr BRACKETR)+
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

  // (BRACKETL logic_and_expr BRACKETR)+
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

  // BRACKETL logic_and_expr BRACKETR
  private static boolean indexed_access_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "indexed_access_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BRACKETL);
    r = r && logic_and_expr(b, l + 1);
    r = r && consumeToken(b, BRACKETR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logic_or_expr AND logic_or_expr | logic_or_expr
  public static boolean logic_and_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_and_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGIC_AND_EXPR, "<logic and expr>");
    r = logic_and_expr_0(b, l + 1);
    if (!r) r = logic_or_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // logic_or_expr AND logic_or_expr
  private static boolean logic_and_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_and_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logic_or_expr(b, l + 1);
    r = r && consumeToken(b, AND);
    r = r && logic_or_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // NOT compare_expr | compare_expr
  public static boolean logic_not_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_not_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGIC_NOT_EXPR, "<logic not expr>");
    r = logic_not_expr_0(b, l + 1);
    if (!r) r = compare_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NOT compare_expr
  private static boolean logic_not_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_not_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NOT);
    r = r && compare_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logic_not_expr OR logic_not_expr | logic_not_expr
  public static boolean logic_or_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_or_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGIC_OR_EXPR, "<logic or expr>");
    r = logic_or_expr_0(b, l + 1);
    if (!r) r = logic_not_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // logic_not_expr OR logic_not_expr
  private static boolean logic_or_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logic_or_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = logic_not_expr(b, l + 1);
    r = r && consumeToken(b, OR);
    r = r && logic_not_expr(b, l + 1);
    exit_section_(b, m, null, r);
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
  // plus_minus_expr (MUL | DIV) plus_minus_expr | plus_minus_expr
  public static boolean mul_div_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_div_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MUL_DIV_EXPR, "<mul div expr>");
    r = mul_div_expr_0(b, l + 1);
    if (!r) r = plus_minus_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // plus_minus_expr (MUL | DIV) plus_minus_expr
  private static boolean mul_div_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_div_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = plus_minus_expr(b, l + 1);
    r = r && mul_div_expr_0_1(b, l + 1);
    r = r && plus_minus_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MUL | DIV
  private static boolean mul_div_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mul_div_expr_0_1")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    return r;
  }

  /* ********************************************************** */
  // term_expr (PLUS | MINUS) term_expr | term_expr
  public static boolean plus_minus_expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_minus_expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PLUS_MINUS_EXPR, "<plus minus expr>");
    r = plus_minus_expr_0(b, l + 1);
    if (!r) r = term_expr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // term_expr (PLUS | MINUS) term_expr
  private static boolean plus_minus_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_minus_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = term_expr(b, l + 1);
    r = r && plus_minus_expr_0_1(b, l + 1);
    r = r && term_expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean plus_minus_expr_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "plus_minus_expr_0_1")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
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
  // (PROGRAM | MODULE) IDENT
  public static boolean program_header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_header")) return false;
    if (!nextTokenIs(b, "<program header>", MODULE, PROGRAM)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROGRAM_HEADER, "<program header>");
    r = program_header_0(b, l + 1);
    r = r && consumeToken(b, IDENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PROGRAM | MODULE
  private static boolean program_header_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "program_header_0")) return false;
    boolean r;
    r = consumeToken(b, PROGRAM);
    if (!r) r = consumeToken(b, MODULE);
    return r;
  }

  /* ********************************************************** */
  // COLON INDENT var_definitions UNINDENT
  public static boolean record_body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "record_body")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, INDENT);
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
  // RETURN logic_and_expr
  public static boolean return_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "return_statement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && logic_and_expr(b, l + 1);
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
  // return_statement
  //     | assignment_statement
  //     | function_invocation
  //     | if_statement
  //     | for_statement
  //     | while_statement
  public static boolean statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "statement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATEMENT, "<statement>");
    r = return_statement(b, l + 1);
    if (!r) r = assignment_statement(b, l + 1);
    if (!r) r = function_invocation(b, l + 1);
    if (!r) r = if_statement(b, l + 1);
    if (!r) r = for_statement(b, l + 1);
    if (!r) r = while_statement(b, l + 1);
    exit_section_(b, l, m, r, false, null);
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
  // (PARENTHESISL logic_and_expr PARENTHESISR)
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

  // PARENTHESISL logic_and_expr PARENTHESISR
  private static boolean term_expr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "term_expr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, PARENTHESISL);
    r = r && logic_and_expr(b, l + 1);
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
  // VAR INDENT var_definitions UNINDENT
  public static boolean var_block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_block")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, VAR, INDENT);
    r = r && var_definitions(b, l + 1);
    r = r && consumeToken(b, UNINDENT);
    exit_section_(b, m, VAR_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // IDENT COLON type_definition
  public static boolean var_definition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definition")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENT, COLON);
    r = r && type_definition(b, l + 1);
    exit_section_(b, m, VAR_DEFINITION, r);
    return r;
  }

  /* ********************************************************** */
  // var_definition+
  public static boolean var_definitions(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_definitions")) return false;
    if (!nextTokenIs(b, IDENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = var_definition(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!var_definition(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_definitions", c)) break;
    }
    exit_section_(b, m, VAR_DEFINITIONS, r);
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
  // WHILE logic_and_expr block_statements_body
  public static boolean while_statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "while_statement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && logic_and_expr(b, l + 1);
    r = r && block_statements_body(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

}
