package com.exchanger.ui.theme.local_composition

import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalAlpha = staticCompositionLocalOf { Alpha }

data class ThemeAlpha(
    val alpha_0: Float = 0F,
    val alpha_10: Float = 0.1F,
    val alpha_20: Float = 0.2F,
    val alpha_30: Float = 0.3F,
    val alpha_40: Float = 0.4F,
    val alpha_50: Float = 0.5F,
    val alpha_60: Float = 0.6F,
    val alpha_70: Float = 0.7F,
    val alpha_80: Float = 0.8F,
    val alpha_90: Float = 0.9F,
    val alpha_100: Float = 1F,
)

val Alpha = ThemeAlpha()