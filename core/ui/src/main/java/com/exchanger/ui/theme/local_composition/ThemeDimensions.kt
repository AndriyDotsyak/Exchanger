package com.exchanger.ui.theme.local_composition

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

val LocalDimensions = staticCompositionLocalOf<Dimensions> { ThemeDimensions() }

class ThemeDimensions : Dimensions {

    override val space_8: Dp = 8.dp
    override val space_16: Dp = 16.dp
    override val space_24: Dp = 24.dp
    override val space_32: Dp = 32.dp
    override val space_56: Dp = 56.dp

    override val size_2: Dp = 2.dp
    override val size_4: Dp = 4.dp
    override val size_8: Dp = 8.dp
    override val size_12: Dp = 12.dp
    override val size_24: Dp = 24.dp
    override val size_32: Dp = 32.dp
    override val size_44: Dp = 44.dp
    override val size_48: Dp = 48.dp
    override val size_54: Dp = 54.dp
    override val size_56: Dp = 56.dp

    override val text_size_12: TextUnit = 12.sp
    override val text_size_14: TextUnit = 14.sp
    override val text_size_16: TextUnit = 16.sp
    override val text_size_18: TextUnit = 18.sp
    override val text_size_20: TextUnit = 20.sp
    override val text_size_24: TextUnit = 24.sp
    override val text_size_28: TextUnit = 28.sp
    override val text_size_32: TextUnit = 32.sp
    override val text_size_36: TextUnit = 36.sp

}

interface Dimensions {

    val space_8: Dp
    val space_16: Dp
    val space_24: Dp
    val space_32: Dp
    val space_56: Dp

    val size_2: Dp
    val size_4: Dp
    val size_8: Dp
    val size_12: Dp
    val size_24: Dp
    val size_32: Dp
    val size_44: Dp
    val size_48: Dp
    val size_54: Dp
    val size_56: Dp

    val text_size_12: TextUnit
    val text_size_14: TextUnit
    val text_size_16: TextUnit
    val text_size_18: TextUnit
    val text_size_20: TextUnit
    val text_size_24: TextUnit
    val text_size_28: TextUnit
    val text_size_32: TextUnit
    val text_size_36: TextUnit

}

@Composable
fun provideDimensions(): Dimensions {
    return ThemeDimensions()
}