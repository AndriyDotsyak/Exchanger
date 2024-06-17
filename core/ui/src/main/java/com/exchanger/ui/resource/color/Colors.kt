package com.exchanger.ui.resource.color

import androidx.compose.ui.graphics.Color

interface ThemeColors {
    val core: Core
    val background: Background
    val content: Content
    val border: Border
    val gradient: Gradient
}

interface Core {
    val primary: Color
    val accent: Color
    val negative: Color
    val positive: Color
}

interface Background {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val active: Color
    val disabled: Color
}

interface Content {
    val primary: Color
    val secondary: Color
    val tertiary: Color
    val quaternary: Color
    val disabled: Color
}

interface Border {
    val primary: Color
}

interface Gradient {
    val primaryStart: Color
    val primaryEnd: Color
}