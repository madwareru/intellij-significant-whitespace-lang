/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.github.madwareru.intellijsignificantwhitespacelang.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import java.util.ArrayDeque;import java.util.Deque;import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.madwareru.intellijsignificantwhitespacelang.language.psi.PyPasTypes.*;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>PyPasLexer.flex</tt>
 */
public class PyPasLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IN_INDENT = 2;
  public static final int IN_INDENT_STACK_ROLLBACK = 4;
  public static final int IN_INDENT_STACK_ROLLBACK1 = 6;
  public static final int IN_FINAL = 8;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2,  2,  2,  2,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [7, 7, 7]
   * Total runtime size is 1928 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>14]|((ch>>7)&0x7f)]<<7)|(ch&0x7f)];
  }

  /* The ZZ_CMAP_Z table has 68 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\103\200");

  /* The ZZ_CMAP_Y table has 256 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\53\2\1\3\22\2\1\4\37\2\1\3\237\2");

  /* The ZZ_CMAP_A table has 640 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\26\1\1\1\3\2\0\1\24\22\26\1\67\1\53\1\23\2\26\1\50\1\43\1\22\1\27\1\30"+
    "\1\51\1\47\1\37\1\16\1\20\1\2\12\15\1\35\1\36\1\54\1\52\1\55\2\26\4\14\1\21"+
    "\25\14\1\31\1\25\1\32\1\46\1\17\1\26\1\11\1\14\1\62\1\41\1\7\1\10\1\60\1\65"+
    "\1\63\2\14\1\12\1\61\1\40\1\42\1\57\1\14\1\5\1\13\1\4\1\6\1\56\1\64\1\14\1"+
    "\66\1\14\1\33\1\44\1\34\1\45\6\26\1\0\32\26\1\0\337\26\1\0\177\26\13\0\35"+
    "\26\2\0\5\26\1\0\57\26\1\0\40\26");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\6\5\1\6\1\7"+
    "\1\10\3\1\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\1\20\1\21\2\5\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\1\1\32\1\33\5\5"+
    "\1\34\1\35\1\36\2\0\1\37\1\5\1\40\7\5"+
    "\1\41\1\5\1\6\1\42\3\0\1\43\1\0\1\44"+
    "\1\5\1\45\1\46\1\47\1\50\1\51\3\5\1\52"+
    "\6\5\1\53\2\5\1\54\1\5\1\55\1\0\2\56"+
    "\1\43\1\57\1\60\3\5\1\61\2\5\1\62\1\63"+
    "\2\5\1\42\7\5\1\64\3\5\1\65\1\66\1\67"+
    "\3\5\1\70\1\5\1\71\1\5\1\72\1\5\1\73";

  private static int [] zzUnpackAction() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\340\0\u0118\0\250\0\u0150"+
    "\0\u0188\0\u01c0\0\u01f8\0\u0230\0\u0268\0\u02a0\0\u02d8\0\u0310"+
    "\0\u0348\0\u0380\0\340\0\250\0\250\0\250\0\250\0\250"+
    "\0\250\0\u03b8\0\250\0\250\0\u03f0\0\u0428\0\250\0\250"+
    "\0\250\0\250\0\u02d8\0\250\0\250\0\250\0\u0460\0\u0498"+
    "\0\u04d0\0\u0508\0\u0540\0\u0578\0\u05b0\0\u05e8\0\250\0\250"+
    "\0\250\0\340\0\u0118\0\u0620\0\u0658\0\u01c0\0\u0690\0\u06c8"+
    "\0\u0700\0\u0738\0\u0770\0\u07a8\0\u07e0\0\u01c0\0\u0818\0\u0850"+
    "\0\u0888\0\u08c0\0\u08f8\0\u0380\0\250\0\u0930\0\250\0\u0968"+
    "\0\u01c0\0\u01c0\0\250\0\250\0\250\0\u09a0\0\u09d8\0\u0a10"+
    "\0\u01c0\0\u0a48\0\u0a80\0\u0ab8\0\u0af0\0\u0b28\0\u0b60\0\u01c0"+
    "\0\u0b98\0\u0bd0\0\u01c0\0\u0c08\0\u01c0\0\u0c40\0\250\0\u08c0"+
    "\0\u0380\0\u01c0\0\u01c0\0\u0c78\0\u0cb0\0\u0ce8\0\u01c0\0\u0d20"+
    "\0\u0d58\0\u01c0\0\u01c0\0\u0d90\0\u0dc8\0\u0c40\0\u0e00\0\u0e38"+
    "\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u01c0\0\u0f88\0\u0fc0"+
    "\0\u0ff8\0\u01c0\0\u01c0\0\u01c0\0\u1030\0\u1068\0\u10a0\0\u01c0"+
    "\0\u10d8\0\u01c0\0\u1110\0\u01c0\0\u1148\0\u01c0";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\14\1\15\3\12\1\16\1\17\1\12\1\20\1\12"+
    "\1\21\1\22\1\23\2\4\1\24\1\25\1\26\1\27"+
    "\1\30\1\31\1\32\1\33\1\34\1\35\1\12\1\36"+
    "\1\37\1\40\1\41\1\42\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\51\1\52\1\53\1\12\1\54\1\12"+
    "\1\55\1\56\2\12\1\5\1\57\1\60\65\57\1\61"+
    "\70\4\71\0\1\62\1\63\1\7\20\0\1\62\42\0"+
    "\1\62\2\0\1\64\71\0\1\12\1\65\10\12\1\0"+
    "\1\12\1\0\1\12\16\0\2\12\1\66\13\0\11\12"+
    "\5\0\3\12\1\67\6\12\1\0\1\12\1\0\1\12"+
    "\16\0\3\12\13\0\11\12\5\0\12\12\1\0\1\12"+
    "\1\0\1\12\16\0\3\12\13\0\11\12\5\0\6\12"+
    "\1\70\3\12\1\0\1\12\1\0\1\12\16\0\1\71"+
    "\2\12\13\0\11\12\5\0\2\12\1\72\2\12\1\73"+
    "\4\12\1\0\1\12\1\0\1\12\16\0\2\12\1\74"+
    "\13\0\11\12\5\0\1\12\1\75\5\12\1\76\2\12"+
    "\1\0\1\12\1\0\1\12\16\0\1\77\2\12\13\0"+
    "\11\12\16\0\1\16\1\0\1\100\1\101\64\0\1\16"+
    "\67\0\1\101\52\0\3\102\1\0\17\102\2\0\1\103"+
    "\42\102\3\104\1\0\17\104\1\105\1\0\1\106\42\104"+
    "\52\0\1\107\21\0\12\12\1\0\1\12\1\0\1\12"+
    "\16\0\2\12\1\110\13\0\11\12\5\0\1\12\1\111"+
    "\2\12\1\112\5\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\53\0\1\113\67\0\1\114\67\0"+
    "\1\115\21\0\5\12\1\116\4\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\11\12\5\0\1\12\1\117"+
    "\10\12\1\0\1\12\1\0\1\12\16\0\3\12\13\0"+
    "\11\12\5\0\12\12\1\0\1\12\1\0\1\12\16\0"+
    "\2\12\1\120\13\0\11\12\5\0\4\12\1\121\5\12"+
    "\1\0\1\12\1\0\1\12\16\0\3\12\13\0\11\12"+
    "\5\0\12\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\7\12\1\122\1\12\1\0\3\64\1\0\64\64"+
    "\4\0\2\12\1\123\7\12\1\0\1\12\1\0\1\12"+
    "\16\0\3\12\13\0\11\12\5\0\1\124\11\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\4\12\1\125"+
    "\4\12\5\0\7\12\1\126\2\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\5\12\1\127\3\12\5\0"+
    "\12\12\1\0\1\12\1\0\1\12\16\0\1\12\1\130"+
    "\1\12\13\0\11\12\5\0\12\12\1\0\1\12\1\0"+
    "\1\12\16\0\1\131\2\12\13\0\11\12\5\0\6\12"+
    "\1\132\3\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\11\12\5\0\1\12\1\133\10\12\1\0\1\12"+
    "\1\0\1\12\16\0\3\12\13\0\11\12\5\0\1\12"+
    "\1\134\10\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\11\12\5\0\12\12\1\0\1\12\1\0\1\12"+
    "\16\0\1\12\1\135\1\12\13\0\11\12\16\0\1\100"+
    "\1\0\1\100\57\0\1\136\5\0\1\101\3\0\1\136"+
    "\70\0\1\137\47\0\1\102\1\0\16\102\1\140\1\102"+
    "\1\0\42\102\1\0\3\104\1\0\17\104\1\141\1\0"+
    "\1\106\42\104\4\0\1\142\11\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\11\12\5\0\1\12\1\143"+
    "\10\12\1\0\1\12\1\0\1\12\16\0\3\12\13\0"+
    "\11\12\5\0\12\12\1\0\1\12\1\0\1\12\16\0"+
    "\2\12\1\144\13\0\11\12\5\0\12\12\1\0\1\12"+
    "\1\0\1\12\16\0\1\12\1\145\1\12\13\0\11\12"+
    "\5\0\12\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\5\12\1\146\3\12\5\0\3\12\1\147\6\12"+
    "\1\0\1\12\1\0\1\12\16\0\3\12\13\0\11\12"+
    "\5\0\2\12\1\150\7\12\1\0\1\12\1\0\1\12"+
    "\16\0\3\12\13\0\11\12\5\0\12\12\1\0\1\12"+
    "\1\0\1\12\16\0\2\12\1\151\13\0\11\12\5\0"+
    "\3\12\1\152\6\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\5\0\4\12\1\153\5\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\11\12\5\0"+
    "\12\12\1\0\1\12\1\0\1\12\16\0\3\12\13\0"+
    "\4\12\1\154\4\12\5\0\7\12\1\123\2\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\11\12\5\0"+
    "\5\12\1\155\4\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\16\0\1\156\56\0\12\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\2\12\1\157"+
    "\1\12\1\160\4\12\5\0\2\12\1\161\7\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\11\12\5\0"+
    "\6\12\1\162\3\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\5\0\1\12\1\163\10\12\1\0"+
    "\1\12\1\0\1\12\16\0\3\12\13\0\11\12\5\0"+
    "\1\12\1\164\10\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\5\0\1\165\11\12\1\0\1\12"+
    "\1\0\1\12\16\0\3\12\13\0\11\12\5\0\12\12"+
    "\1\0\1\12\1\0\1\12\16\0\3\12\13\0\10\12"+
    "\1\166\5\0\1\12\1\167\10\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\11\12\5\0\3\12\1\170"+
    "\6\12\1\0\1\12\1\0\1\12\16\0\3\12\13\0"+
    "\11\12\5\0\6\12\1\171\3\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\11\12\5\0\3\12\1\172"+
    "\6\12\1\0\1\12\1\0\1\12\16\0\3\12\13\0"+
    "\11\12\5\0\12\12\1\0\1\12\1\0\1\12\16\0"+
    "\1\173\2\12\13\0\11\12\5\0\12\12\1\0\1\12"+
    "\1\0\1\12\16\0\1\12\1\174\1\12\13\0\11\12"+
    "\5\0\12\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\5\12\1\175\3\12\5\0\5\12\1\176\4\12"+
    "\1\0\1\12\1\0\1\12\16\0\3\12\13\0\11\12"+
    "\5\0\12\12\1\0\1\12\1\0\1\12\16\0\1\12"+
    "\1\177\1\12\13\0\11\12\5\0\3\12\1\200\6\12"+
    "\1\0\1\12\1\0\1\12\16\0\3\12\13\0\11\12"+
    "\5\0\12\12\1\0\1\12\1\0\1\12\16\0\2\12"+
    "\1\201\13\0\11\12\5\0\12\12\1\0\1\12\1\0"+
    "\1\12\16\0\3\12\13\0\3\12\1\202\5\12\5\0"+
    "\2\12\1\203\7\12\1\0\1\12\1\0\1\12\16\0"+
    "\3\12\13\0\11\12\5\0\12\12\1\0\1\12\1\0"+
    "\1\12\16\0\1\204\2\12\13\0\11\12\5\0\1\12"+
    "\1\205\10\12\1\0\1\12\1\0\1\12\16\0\3\12"+
    "\13\0\11\12\5\0\3\12\1\206\6\12\1\0\1\12"+
    "\1\0\1\12\16\0\3\12\13\0\11\12\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[4480];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\2\1\1\11\14\1\6\11\1\1\2\11"+
    "\2\1\4\11\1\1\3\11\10\1\3\11\2\0\16\1"+
    "\3\0\1\11\1\0\1\11\3\1\3\11\20\1\1\0"+
    "\1\11\47\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[134];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public PyPasLexer() {
        this((java.io.Reader)null);
    }
    private boolean atBeginningOfTheLine = true;
    private Deque<Integer> indentStack = new ArrayDeque<Integer>();
    private int currentIndent = 0;
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


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public PyPasLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 60: break;
          case 2: 
            { if (!checkBol()) { return WHITE_SPACE; }
            } 
            // fall through
          case 61: break;
          case 3: 
            { if (!checkBol()) { return DIV; }
            } 
            // fall through
          case 62: break;
          case 4: 
            { if (atBeginningOfTheLine) {
                                 return WHITE_SPACE;
                             }
                             atBeginningOfTheLine = true;
                             return NEW_LINE;
            } 
            // fall through
          case 63: break;
          case 5: 
            { if (!checkBol()) { return IDENT; }
            } 
            // fall through
          case 64: break;
          case 6: 
            { if (!checkBol()) { return INTEGER; }
            } 
            // fall through
          case 65: break;
          case 7: 
            { if (!checkBol()) { return MINUS; }
            } 
            // fall through
          case 66: break;
          case 8: 
            { if (!checkBol()) { return DOT; }
            } 
            // fall through
          case 67: break;
          case 9: 
            { if (!checkBol()) { return PARENTHESISL; }
            } 
            // fall through
          case 68: break;
          case 10: 
            { if (!checkBol()) { return PARENTHESISR; }
            } 
            // fall through
          case 69: break;
          case 11: 
            { if (!checkBol()) { return BRACKETL; }
            } 
            // fall through
          case 70: break;
          case 12: 
            { if (!checkBol()) { return BRACKETR; }
            } 
            // fall through
          case 71: break;
          case 13: 
            { if (!checkBol()) { return BRACEL; }
            } 
            // fall through
          case 72: break;
          case 14: 
            { if (!checkBol()) { return BRACER; }
            } 
            // fall through
          case 73: break;
          case 15: 
            { if (!checkBol()) { return COLON; }
            } 
            // fall through
          case 74: break;
          case 16: 
            { if (!checkBol()) { return SEMICOLON; }
            } 
            // fall through
          case 75: break;
          case 17: 
            { if (!checkBol()) { return COMMA; }
            } 
            // fall through
          case 76: break;
          case 18: 
            { if (!checkBol()) { return BITWISE_AND; }
            } 
            // fall through
          case 77: break;
          case 19: 
            { if (!checkBol()) { return BITWISE_OR; }
            } 
            // fall through
          case 78: break;
          case 20: 
            { if (!checkBol()) { return BITWISE_NOT; }
            } 
            // fall through
          case 79: break;
          case 21: 
            { if (!checkBol()) { return BITWISE_XOR; }
            } 
            // fall through
          case 80: break;
          case 22: 
            { if (!checkBol()) { return PLUS; }
            } 
            // fall through
          case 81: break;
          case 23: 
            { if (!checkBol()) { return MOD; }
            } 
            // fall through
          case 82: break;
          case 24: 
            { if (!checkBol()) { return MUL; }
            } 
            // fall through
          case 83: break;
          case 25: 
            { if (!checkBol()) { return EQ_OP; }
            } 
            // fall through
          case 84: break;
          case 26: 
            { if (!checkBol()) { return LT_OP; }
            } 
            // fall through
          case 85: break;
          case 27: 
            { if (!checkBol()) { return HT_OP; }
            } 
            // fall through
          case 86: break;
          case 28: 
            { return handleIndentUnindent();
            } 
            // fall through
          case 87: break;
          case 29: 
            { currentIndent += 4;
            } 
            // fall through
          case 88: break;
          case 30: 
            { currentIndent ++;
            } 
            // fall through
          case 89: break;
          case 31: 
            { return COMMENT;
            } 
            // fall through
          case 90: break;
          case 32: 
            { if (!checkBol()) { return TO; }
            } 
            // fall through
          case 91: break;
          case 33: 
            { if (!checkBol()) { return AS; }
            } 
            // fall through
          case 92: break;
          case 34: 
            { if (!checkBol()) { return FLOAT; }
            } 
            // fall through
          case 93: break;
          case 35: 
            { if (!checkBol()) { return STRING; }
            } 
            // fall through
          case 94: break;
          case 36: 
            { if (!checkBol()) { return ASSIGNMENT_OP; }
            } 
            // fall through
          case 95: break;
          case 37: 
            { if (!checkBol()) { return OR; }
            } 
            // fall through
          case 96: break;
          case 38: 
            { if (!checkBol()) { return OF; }
            } 
            // fall through
          case 97: break;
          case 39: 
            { if (!checkBol()) { return NEQ_OP; }
            } 
            // fall through
          case 98: break;
          case 40: 
            { if (!checkBol()) { return LTEQ_OP; }
            } 
            // fall through
          case 99: break;
          case 41: 
            { if (!checkBol()) { return HTEQ_OP; }
            } 
            // fall through
          case 100: break;
          case 42: 
            { if (!checkBol()) { return IF; }
            } 
            // fall through
          case 101: break;
          case 43: 
            { if (!checkBol()) { return END; }
            } 
            // fall through
          case 102: break;
          case 44: 
            { if (!checkBol()) { return FOR; }
            } 
            // fall through
          case 103: break;
          case 45: 
            { if (!checkBol()) { return AND; }
            } 
            // fall through
          case 104: break;
          case 46: 
            { if (!checkBol()) { return CHAR; }
            } 
            // fall through
          case 105: break;
          case 47: 
            { if (!checkBol()) { return NOT; }
            } 
            // fall through
          case 106: break;
          case 48: 
            { if (!checkBol()) { return VAR; }
            } 
            // fall through
          case 107: break;
          case 49: 
            { if (!checkBol()) { return BOOLEAN; }
            } 
            // fall through
          case 108: break;
          case 50: 
            { if (!checkBol()) { return ELSE; }
            } 
            // fall through
          case 109: break;
          case 51: 
            { if (!checkBol()) { return ELIF; }
            } 
            // fall through
          case 110: break;
          case 52: 
            { if (!checkBol()) { return ARRAY; }
            } 
            // fall through
          case 111: break;
          case 53: 
            { if (!checkBol()) { return WHILE; }
            } 
            // fall through
          case 112: break;
          case 54: 
            { if (!checkBol()) { return RETURN; }
            } 
            // fall through
          case 113: break;
          case 55: 
            { if (!checkBol()) { return RECORD; }
            } 
            // fall through
          case 114: break;
          case 56: 
            { if (!checkBol()) { return MODULE; }
            } 
            // fall through
          case 115: break;
          case 57: 
            { if (!checkBol()) { return PROGRAM; }
            } 
            // fall through
          case 116: break;
          case 58: 
            { if (!checkBol()) { return FUNCTION; }
            } 
            // fall through
          case 117: break;
          case 59: 
            { if (!checkBol()) { return PROCEDURE; }
            } 
            // fall through
          case 118: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
