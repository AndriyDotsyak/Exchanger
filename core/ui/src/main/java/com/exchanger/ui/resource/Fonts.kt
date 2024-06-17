package com.exchanger.ui.resource

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.exchanger.core.resource.R

object Fonts {

    val Roboto = FontFamily(
        Font(R.font.public_sans_thin, FontWeight.Thin),
        Font(R.font.public_sans_light, FontWeight.Light),
        Font(R.font.public_sans_regular, FontWeight.Normal),
        Font(R.font.public_sans_semi_bold, FontWeight.SemiBold),
        Font(R.font.public_sans_medium, FontWeight.Medium),
        Font(R.font.public_sans_bold, FontWeight.Bold),
        Font(R.font.public_sans_black, FontWeight.Black)
    )

}