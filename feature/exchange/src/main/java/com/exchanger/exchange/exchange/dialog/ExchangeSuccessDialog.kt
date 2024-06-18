package com.exchanger.exchange.exchange.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.window.Dialog
import com.exchanger.core.resource.R
import com.exchanger.model.exchange.ExchangeResult
import com.exchanger.ui.component.spacer.VerticalSpacer
import com.exchanger.ui.theme.AppTheme

@Composable
fun ExchangeSuccessDialog(
    data: ExchangeResult,
    isVisible: Boolean = true,
    onDismiss: () -> Unit
) {
    if (isVisible) {
        Dialog(
            onDismissRequest = onDismiss
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(AppTheme.shapes.around.medium)
                    .background(
                        AppTheme.colors.background.secondary.copy(
                            alpha = AppTheme.alpha.alpha_80
                        )
                    ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                VerticalSpacer(AppTheme.dimensions.space_16)

                Text(
                    text = stringResource(R.string.exchange_success_title),
                    style = AppTheme.typography.titleMedium,
                    fontWeight = FontWeight.SemiBold,
                    color = AppTheme.colors.content.primary
                )

                VerticalSpacer(AppTheme.dimensions.space_8)

                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = AppTheme.dimensions.space_16),
                    text = if (data.isFeeCharged) {
                        stringResource(
                            R.string.exchange_success_description_fee,
                            data.amountSell,
                            data.currencySell,
                            data.amountReceive,
                            data.currencyReceive,
                            data.fee,
                            data.currencySell
                        )
                    } else {
                        stringResource(
                            R.string.exchange_success_description,
                            data.amountSell,
                            data.currencySell,
                            data.amountReceive,
                            data.currencyReceive
                        )
                    },
                    style = AppTheme.typography.bodyMedium,
                    color = AppTheme.colors.content.primary,
                    textAlign = TextAlign.Center
                )

                VerticalSpacer(AppTheme.dimensions.space_16)

                HorizontalDivider(
                    color = AppTheme.colors.border.secondary
                )

                Button(
                    onClick = onDismiss,
                    colors = ButtonDefaults.textButtonColors()
                ) {
                    Text(
                        text = stringResource(R.string.exchange_success_done),
                        style = AppTheme.typography.titleMedium,
                        fontWeight = FontWeight.SemiBold,
                        color = AppTheme.colors.core.accent
                    )
                }
            }
        }
    }
}