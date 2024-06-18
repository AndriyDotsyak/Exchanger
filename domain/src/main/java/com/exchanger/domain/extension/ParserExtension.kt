package com.exchanger.domain.extension

private const val CHAR_COMMA = ','
private const val CHAR_DOT = '.'

fun String.parseDouble(): Double {
    return replace(CHAR_COMMA, CHAR_DOT).toDoubleOrNull() ?: 0.0
}