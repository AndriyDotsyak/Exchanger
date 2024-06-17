package com.exchanger.data.network

import com.exchanger.model.exchange.ExchangeRate
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class ExchangeApi @Inject constructor(
    private val client: HttpClient
) {

    suspend fun getExchangeRates(): ExchangeRate {
        return client.get(urlString = "tasks/api/currency-exchange-rates").body()
    }

}