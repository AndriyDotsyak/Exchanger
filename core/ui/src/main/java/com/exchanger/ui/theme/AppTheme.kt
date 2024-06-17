package com.exchanger.ui.theme

import androidx.compose.runtime.Composable
import com.exchanger.ui.theme.local_composition.LocalColors
import com.exchanger.ui.theme.local_composition.LocalTypography
import androidx.compose.material3.Typography
import com.exchanger.ui.resource.color.ThemeColors
import com.exchanger.ui.theme.local_composition.Dimensions
import com.exchanger.ui.theme.local_composition.LocalAlpha
import com.exchanger.ui.theme.local_composition.LocalDimensions
import com.exchanger.ui.theme.local_composition.LocalIcons
import com.exchanger.ui.theme.local_composition.LocalShapes
import com.exchanger.ui.theme.local_composition.ThemeAlpha
import com.exchanger.ui.theme.local_composition.ThemeIcons
import com.exchanger.ui.theme.local_composition.ThemeShapes

object AppTheme {

    val colors: ThemeColors
        @Composable get() = LocalColors.current

    val icons: ThemeIcons
        @Composable get() = LocalIcons.current

    val alpha: ThemeAlpha
        @Composable get() = LocalAlpha.current

    val dimensions: Dimensions
        @Composable get() = LocalDimensions.current

    val shapes: ThemeShapes
        @Composable get() = LocalShapes.current

    val typography: Typography
        @Composable get() = LocalTypography.current


}