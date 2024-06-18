package com.exchanger.data.repository.exchange

import com.exchanger.data.mapper.ExchangeRateMapper
import com.exchanger.data.source.exchange.ExchangeLocalDataSource
import com.exchanger.data.source.exchange.ExchangeRemoteDataSource
import com.exchanger.model.exchange.ExchangeRate
import javax.inject.Inject

class ExchangeDefaultRepository @Inject constructor(
    private val remoteSource: ExchangeRemoteDataSource,
    private val localSource: ExchangeLocalDataSource
) : ExchangeRepository {

    override suspend fun getExchangeRates(): ExchangeRate {
        return ExchangeRateMapper.map(remoteSource.getExchangeRates())
    }

    override fun getExchangeCount(): Int {
        return localSource.getExchangeCount()
    }

    override suspend fun incrementExchangeCount() {
        val count = getExchangeCount()
        localSource.setExchangeCount(count.inc())
    }

}