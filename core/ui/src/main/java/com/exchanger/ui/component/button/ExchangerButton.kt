package com.exchanger.ui.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.exchanger.ui.theme.AppTheme

@Preview
@Composable
fun ExchangerButtonPreview() {
    ExchangerButton(
        title = "Title",
        onClick = {}
    )
}

@Composable
fun ExchangerButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .height(AppTheme.dimensions.size_54)
            .clip(AppTheme.shapes.around.extraLarge)
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        AppTheme.colors.gradient.primaryStart,
                        AppTheme.colors.gradient.primaryEnd
                    )
                )
            )
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title.uppercase(),
            color = AppTheme.colors.content.quaternary,
            style = AppTheme.typography.bodySmall,
            fontWeight = FontWeight.SemiBold
        )
    }
}