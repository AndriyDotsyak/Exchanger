package com.exchanger.ui.theme.local_composition

import androidx.compose.runtime.staticCompositionLocalOf
import com.exchanger.ui.resource.color.ColorsDark
import com.exchanger.ui.resource.color.ColorsLight
import com.exchanger.ui.resource.color.ThemeColors

internal val LocalColors = staticCompositionLocalOf<ThemeColors> { ColorsLight }

fun provideColors(isDarkTheme: Boolean): ThemeColors {
    return if (isDarkTheme)
        ColorsDark else ColorsLight
}