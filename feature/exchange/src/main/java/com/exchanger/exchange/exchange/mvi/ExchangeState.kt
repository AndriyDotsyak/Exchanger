package com.exchanger.exchange.exchange.mvi

import com.exchanger.model.balance.Balance
import com.exchanger.model.exchange.ExchangeRate

data class ExchangeState(
    val exchangeRate: ExchangeRate = ExchangeRate(),
    val balances: List<Balance> = emptyList(),
    val amountSell: String = String(),
    val amountReceive: String = String(),
    val selectedCurrencySell: Balance = Balance(),
    val selectedCurrencyReceive: Balance = Balance(),
)
