package com.exchanger.domain.extension

private const val CHAR_COMMA = ','
private const val CHAR_DOT = '.'
private const val REGEX_NON_DIGIT = "[^\\d,.]"

fun String.formatInputCurrency(): String {
    return replace(CHAR_COMMA, CHAR_DOT)
        .removeNonNumeric()
}

fun String.removeNonNumeric(): String {
    return replace(REGEX_NON_DIGIT.toRegex(), String())
}