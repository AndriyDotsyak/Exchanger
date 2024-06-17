package com.exchanger.ui.theme.local_composition

import androidx.annotation.DrawableRes
import androidx.compose.runtime.staticCompositionLocalOf
import com.exchanger.core.resource.R

internal val LocalIcons = staticCompositionLocalOf { LightIcons }

data class ThemeIcons(
    @DrawableRes val arrowUp: Int = R.drawable.ic_arrow_up,
    @DrawableRes val arrowDown: Int = R.drawable.ic_arrow_down,
)

val LightIcons = ThemeIcons()

val DarkIcons = ThemeIcons()

fun provideIcons(isDarkTheme: Boolean): ThemeIcons {
    return if (isDarkTheme)
        DarkIcons else LightIcons
}