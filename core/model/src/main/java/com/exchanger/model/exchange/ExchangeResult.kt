package com.exchanger.model.exchange

data class ExchangeResult(
    val amountSell: Double = 0.0,
    val amountReceive: Double = 0.0,
    val fee: Double = 0.0,
    val currencySell: String = String(),
    val currencyReceive: String = String(),
    val isFeeCharged: Boolean = false
)
