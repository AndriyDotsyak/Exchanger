package com.exchanger.data.repository.exchange

import com.exchanger.data.source.exchange.ExchangeRemoteDataSource
import com.exchanger.model.exchange.ExchangeRate
import javax.inject.Inject

class DefaultExchangeRepository @Inject constructor(
    private val remoteSource: ExchangeRemoteDataSource
) : ExchangeRepository {

    override suspend fun getExchangeRates(): ExchangeRate {
        return remoteSource.getExchangeRates()
    }

}