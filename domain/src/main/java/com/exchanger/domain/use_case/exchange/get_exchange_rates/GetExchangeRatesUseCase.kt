package com.exchanger.domain.use_case.exchange.get_exchange_rates

import com.exchanger.model.exchange.ExchangeRate

interface GetExchangeRatesUseCase {
    suspend operator fun invoke(): ExchangeRate
}