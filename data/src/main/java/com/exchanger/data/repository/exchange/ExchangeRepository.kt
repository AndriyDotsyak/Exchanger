package com.exchanger.data.repository.exchange

import com.exchanger.model.exchange.ExchangeRate

interface ExchangeRepository {
    suspend fun getExchangeRates(): ExchangeRate
}