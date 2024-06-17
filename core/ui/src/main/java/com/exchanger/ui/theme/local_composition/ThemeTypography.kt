package com.exchanger.ui.theme.local_composition

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import com.exchanger.ui.resource.Fonts

internal val LocalTypography = staticCompositionLocalOf { provideTypography() }

fun provideTypography(
    dimensions: Dimensions = ThemeDimensions()
): Typography {
    return Typography(
        headlineLarge = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_36
        ),
        headlineMedium = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_32
        ),
        headlineSmall = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_28
        ),
        titleLarge = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_24
        ),
        titleMedium = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_18
        ),
        titleSmall = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = dimensions.text_size_16
        ),
        bodyLarge = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_20
        ),
        bodyMedium = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_16
        ),
        bodySmall = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_14
        ),
        labelLarge = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_16
        ),
        labelMedium = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_14
        ),
        labelSmall = TextStyle(
            fontFamily = Fonts.Roboto,
            fontWeight = FontWeight.Normal,
            fontSize = dimensions.text_size_12
        )
    )
}