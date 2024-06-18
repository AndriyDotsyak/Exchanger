package com.exchanger.domain.use_case.exchange.converter

import com.exchanger.model.exchange.Rate
import javax.inject.Inject

class ConvertCurrencyDefaultUseCase @Inject constructor() : ConvertCurrencyUseCase {

    override suspend fun invoke(
        rates: List<Rate>,
        currencySell: String,
        currencyReceive: String,
        amount: Double
    ): Double {
        val rateSell = rates.find { it.currency == currencySell }?.rate ?: 0.0
        val rateReceive = rates.find { it.currency == currencyReceive }?.rate ?: 0.0
        val exchangeRate = rateReceive / rateSell
        return exchangeRate * amount
    }

}