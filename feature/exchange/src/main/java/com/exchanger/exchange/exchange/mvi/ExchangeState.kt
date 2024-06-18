package com.exchanger.exchange.exchange.mvi

import com.exchanger.model.balance.Balance
import com.exchanger.model.exchange.ExchangeRate
import com.exchanger.model.exchange.ExchangeResult
import com.exchanger.model.exchange.Rate

data class ExchangeState(
    val exchangeRate: ExchangeRate = ExchangeRate(),
    val balances: List<Balance> = emptyList(),
    val amountSell: String = String(),
    val amountReceive: String = String(),
    val selectedCurrencySell: Rate = Rate(),
    val selectedCurrencyReceive: Rate = Rate(),
    val exchangeResult: ExchangeResult = ExchangeResult(),
    val isVisibleSuccessDialog: Boolean = false,
    val isProfitableExchange: Boolean = false
)
