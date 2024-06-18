package com.exchanger.data.mapper

import com.exchanger.data.models.ExchangeRateDto
import com.exchanger.model.exchange.ExchangeRate
import com.exchanger.model.exchange.Rate

object ExchangeRateMapper {

    fun map(exchangeRate: ExchangeRateDto): ExchangeRate {
        return ExchangeRate(
            base = exchangeRate.base,
            date = exchangeRate.date,
            rates = mapRates(exchangeRate.rates)
        )
    }

    private fun mapRates(rates: Map<String, Double>): List<Rate> {
        return rates.map { rate ->
            Rate(
                currency = rate.key,
                rate = rate.value
            )
        }
    }

}