package com.exchanger.exchange.exchange.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.exchanger.core.resource.R
import com.exchanger.model.balance.Balance
import com.exchanger.ui.theme.AppTheme

@Composable
fun BalanceItem(
    modifier: Modifier = Modifier,
    balance: Balance
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.exchange_balance, balance.amount, balance.name),
            style = AppTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            color = AppTheme.colors.content.primary,
            maxLines = 1
        )
    }
}