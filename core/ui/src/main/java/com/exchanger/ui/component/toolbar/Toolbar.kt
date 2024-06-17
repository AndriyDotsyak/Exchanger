package com.exchanger.ui.component.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.exchanger.ui.theme.AppTheme

@Preview
@Composable
fun ToolbarPreview() {
    Toolbar(title = "Title")
}

@Composable
fun Toolbar(
    modifier: Modifier = Modifier,
    title: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(AppTheme.colors.core.accent)
            .statusBarsPadding()
            .height(AppTheme.dimensions.size_56),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = title,
            style = AppTheme.typography.bodyMedium,
            fontWeight = FontWeight.Normal,
            color = AppTheme.colors.content.quaternary
        )
    }
}