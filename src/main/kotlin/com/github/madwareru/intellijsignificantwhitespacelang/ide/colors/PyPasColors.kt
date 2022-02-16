package com.github.madwareru.intellijsignificantwhitespacelang.ide.colors

import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors as DefaultColors

enum class PyPasColors(val humanName: String, default: TextAttributesKey? = null) {
    COLON("colon", DefaultColors.OPERATION_SIGN),
    COMMA("comma", DefaultColors.COMMA),
    PARENTHESES("parens", DefaultColors.PARENTHESES),
    BRACKETS("brackets", DefaultColors.BRACKETS),
    BRACES("braces", DefaultColors.BRACES),
    BOOLEAN("bool", DefaultColors.KEYWORD),
    NUMBER("number", DefaultColors.NUMBER),
    STRING("string", DefaultColors.STRING),
    OTHER("other", DefaultColors.KEYWORD),
    IDENTIFIER("identifier", DefaultColors.IDENTIFIER),
    COMMENT("comment", DefaultColors.LINE_COMMENT),
    BAD_CHAR("bad_character", HighlighterColors.BAD_CHARACTER),
    ;

    val textAttributesKey = TextAttributesKey.createTextAttributesKey("ron.lang.$humanName", default)
    val attributesDescriptor = AttributesDescriptor(humanName, textAttributesKey)
}