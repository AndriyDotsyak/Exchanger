package com.exchanger.domain.util

import android.icu.text.DecimalFormat
import android.icu.text.DecimalFormatSymbols
import java.math.RoundingMode
import java.util.Locale

object FormatUtil {

    private const val PATTERN_CURRENCY = "0.00"
    private const val CURRENCY_DECIMAL_SEPARATOR = '.'

    fun formatCurrency(value: Double): String {
        return getDecimalFormat(PATTERN_CURRENCY).format(value)
    }

    private fun getDecimalFormat(pattern: String): DecimalFormat {
        val decimalFormat = DecimalFormat(pattern)
        val decimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale.getDefault())
        decimalFormatSymbols.decimalSeparator = CURRENCY_DECIMAL_SEPARATOR
        decimalFormat.decimalFormatSymbols = decimalFormatSymbols
        decimalFormat.roundingMode = RoundingMode.DOWN.ordinal
        return decimalFormat
    }

}