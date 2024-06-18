package com.exchanger.domain.use_case.exchange.get_exchange_rates

import com.exchanger.model.exchange.ExchangeRate
import kotlinx.coroutines.flow.Flow

interface GetExchangeRatesUseCase {
    suspend operator fun invoke(): ExchangeRate
    fun getStream(): Flow<ExchangeRate>
}