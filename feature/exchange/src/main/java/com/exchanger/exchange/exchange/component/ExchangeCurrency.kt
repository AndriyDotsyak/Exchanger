package com.exchanger.exchange.exchange.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import com.exchanger.model.exchange.Rate
import com.exchanger.ui.component.spacer.HorizontalSpacer
import com.exchanger.ui.theme.AppTheme

@Composable
fun ExchangeCurrency(
    modifier: Modifier = Modifier,
    icon: Painter,
    iconTint: Color,
    title: String,
    amount: String,
    amountColor: Color,
    rates: List<Rate>,
    selected: Rate,
    isEnabledInput: Boolean = true,
    onChangeSelected: (item: Rate) -> Unit,
    onChangeAmount: (amount: String) -> Unit
) {
    val keyboardController = LocalSoftwareKeyboardController.current
    val focusManager = LocalFocusManager.current

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(AppTheme.dimensions.size_48),
            painter = icon,
            tint = iconTint,
            contentDescription = null
        )

        HorizontalSpacer(AppTheme.dimensions.space_8)

        Text(
            text = title,
            style = AppTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = AppTheme.colors.content.primary
        )

        HorizontalSpacer(AppTheme.dimensions.space_8)

        TextField(
            modifier = Modifier.weight(1F),
            value = amount,
            textStyle = AppTheme.typography.bodyMedium.copy(
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.End
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Number
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    keyboardController?.hide()
                    focusManager.clearFocus()
                }
            ),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                cursorColor = AppTheme.colors.content.primary,
                focusedTextColor = amountColor,
                unfocusedTextColor = amountColor,
                disabledTextColor = amountColor
            ),
            placeholder = {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "0",
                    style = AppTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold,
                    textAlign = TextAlign.End,
                    color = amountColor
                )
            },
            enabled = isEnabledInput,
            singleLine = true,
            onValueChange = onChangeAmount
        )

        ExposedDropdownRates(
            rates = rates,
            selected = selected,
            onChangeSelected = onChangeSelected
        )
    }
}