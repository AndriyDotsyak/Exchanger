package com.exchanger.domain.use_case.exchange.converter

import com.exchanger.model.exchange.Rate

interface ConvertCurrencyUseCase {
    suspend operator fun invoke(
        rates: List<Rate>,
        currencySell: String,
        currencyReceive: String,
        amount: Double
    ): Double
}