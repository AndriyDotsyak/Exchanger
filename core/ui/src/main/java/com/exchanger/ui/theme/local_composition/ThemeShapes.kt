package com.exchanger.ui.theme.local_composition

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.staticCompositionLocalOf

internal val LocalShapes = staticCompositionLocalOf { provideShapes() }

class ThemeShapes(dimensions: Dimensions) {
    val around: Shapes = Shapes(
        extraSmall = RoundedCornerShape(dimensions.size_4),
        small = RoundedCornerShape(dimensions.size_8),
        medium = RoundedCornerShape(dimensions.size_12),
        large = RoundedCornerShape(dimensions.size_24),
        extraLarge = RoundedCornerShape(dimensions.size_32)
    )
}

fun provideShapes(dimensions: Dimensions = ThemeDimensions()): ThemeShapes {
    return ThemeShapes(dimensions)
}