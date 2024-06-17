package com.exchanger.exchange.exchange.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.exchanger.model.balance.Balance
import com.exchanger.ui.theme.AppTheme

@Composable
fun Balances(
    modifier: Modifier = Modifier,
    balances: List<Balance>
) {
    LazyRow(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = AppTheme.dimensions.space_16
        ),
        horizontalArrangement = Arrangement.spacedBy(AppTheme.dimensions.space_24)
    ) {
        items(balances) { balance ->
            BalanceItem(balance = balance)
        }
    }
}