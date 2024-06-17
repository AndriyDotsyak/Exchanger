package com.exchanger.ui.extension

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstrainScope
import androidx.constraintlayout.compose.ConstrainedLayoutReference

fun ConstrainScope.centerHorizontallyTo(
    other: ConstrainedLayoutReference,
    margin: Dp = 0.dp
) {
    linkTo(
        start = other.start,
        end = other.end,
        startMargin = margin,
        endMargin = margin
    )
}