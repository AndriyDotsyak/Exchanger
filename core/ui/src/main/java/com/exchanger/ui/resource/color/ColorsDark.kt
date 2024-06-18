package com.exchanger.ui.resource.color

import androidx.compose.ui.graphics.Color

object ColorsDark : ThemeColors {

    override val core = object : Core {
        override val primary = Color(0xFFFFFFFF)
        override val accent = Color(0xFF359CDE)
        override val negative = Color(0xFFF05352)
        override val positive = Color(0xFF2F9F6E)
    }

    override val background = object : Background {
        override val primary = Color(0xFF242323)
        override val secondary = Color(0xFF353535)
        override val tertiary = Color(0xFF7A7A7A)
        override val active = Color(0xFF3D3D3D)
        override val disabled = Color(0xFF1F1F1F)
    }

    override val content = object : Content {
        override val primary = Color(0xFFFFFFFF)
        override val secondary = Color(0xFFB8B8B8)
        override val tertiary = Color(0xFF7A7A7A)
        override val quaternary: Color = Color(0xFFFFFFFF)
        override val disabled = Color(0xFF3D3D3D)
    }

    override val border = object : Border {
        override val primary = Color(0xFF7A7A7A)
        override val secondary= Color(0xFF7A7A7A)
    }

    override val gradient = object : Gradient {
        override val primaryStart = Color(0xFF2D85C6)
        override val primaryEnd = Color(0xFF369DDE)
    }

}