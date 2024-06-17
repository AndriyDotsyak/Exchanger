package com.exchanger.ui.theme

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import com.exchanger.ui.theme.local_composition.Alpha
import com.exchanger.ui.theme.local_composition.LocalAlpha
import com.exchanger.ui.theme.local_composition.LocalColors
import com.exchanger.ui.theme.local_composition.LocalDimensions
import com.exchanger.ui.theme.local_composition.LocalIcons
import com.exchanger.ui.theme.local_composition.LocalShapes
import com.exchanger.ui.theme.local_composition.LocalTypography
import com.exchanger.ui.theme.local_composition.provideColors
import com.exchanger.ui.theme.local_composition.provideDimensions
import com.exchanger.ui.theme.local_composition.provideIcons
import com.exchanger.ui.theme.local_composition.provideShapes
import com.exchanger.ui.theme.local_composition.provideTypography

@Composable
fun Theme(
    activity: ComponentActivity,
    isDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val dimensions = provideDimensions()

    LaunchedEffect(isDarkTheme) {
        activity.enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.auto(
                lightScrim = Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb(),
                detectDarkMode = { true }
            ),
            navigationBarStyle = SystemBarStyle.auto(
                lightScrim = Color.Transparent.toArgb(),
                darkScrim = Color.Transparent.toArgb(),
                detectDarkMode = {
                    isDarkTheme
                }
            )
        )
    }

    CompositionLocalProvider(
        LocalColors provides provideColors(isDarkTheme),
        LocalIcons provides provideIcons(isDarkTheme),
        LocalAlpha provides Alpha,
        LocalDimensions provides dimensions,
        LocalShapes provides provideShapes(dimensions),
        LocalTypography provides provideTypography(dimensions)
    ) {
        MaterialTheme(content = content)
    }
}