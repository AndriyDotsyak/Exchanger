package com.exchanger.domain.use_case.exchange.exchange

import com.exchanger.model.exchange.ExchangeResult

interface ExchangeUseCase {
    suspend operator fun invoke(
        currencySell: String,
        currencyReceive: String,
        amountSell: Double,
        amountReceive: Double
    ): ExchangeResult
}