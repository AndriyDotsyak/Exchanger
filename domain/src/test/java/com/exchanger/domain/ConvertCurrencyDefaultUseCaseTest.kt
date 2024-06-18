package com.exchanger.domain

import com.exchanger.domain.use_case.exchange.converter.ConvertCurrencyDefaultUseCase
import com.exchanger.model.exchange.Rate
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ConvertCurrencyDefaultUseCaseTest {

    private lateinit var convertCurrencyUseCase: ConvertCurrencyDefaultUseCase

    @Before
    fun setUp() {
        convertCurrencyUseCase = ConvertCurrencyDefaultUseCase()
    }

    @Test
    fun `invoke with different rates`() = runBlocking {
        val rates = listOf(
            Rate("EUR", 1.0),
            Rate("USD", 0.90)
        )
        val currencySell = "EUR"
        val currencyReceive = "USD"
        val amount = 100.0

        val result = convertCurrencyUseCase.invoke(rates, currencySell, currencyReceive, amount)

        assertEquals(90.0, result, 0.0)
    }

    @Test
    fun `invoke with reverse rates`() = runBlocking {
        val rates = listOf(
            Rate("USD", 1.0),
            Rate("JPY", 110.0)
        )
        val currencySell = "JPY"
        val currencyReceive = "USD"
        val amount = 11000.0

        val result = convertCurrencyUseCase.invoke(rates, currencySell, currencyReceive, amount)

        assertEquals(100.0, result, 0.0)
    }

}