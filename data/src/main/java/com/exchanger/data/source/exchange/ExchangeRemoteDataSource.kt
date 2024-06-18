package com.exchanger.data.source.exchange

import com.exchanger.data.models.ExchangeRateDto
import com.exchanger.data.network.ExchangeApi
import com.exchanger.model.exchange.ExchangeRate
import javax.inject.Inject

class ExchangeRemoteDataSource @Inject constructor(
    private val api: ExchangeApi
) {

    suspend fun getExchangeRates(): ExchangeRateDto {
        return api.getExchangeRates()
    }

}