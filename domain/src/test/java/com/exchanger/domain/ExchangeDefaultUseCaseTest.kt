package com.exchanger.domain

import com.exchanger.data.repository.balance.BalanceRepository
import com.exchanger.data.repository.exchange.ExchangeRepository
import com.exchanger.domain.use_case.exchange.exchange.ExchangeDefaultUseCase
import com.exchanger.model.balance.Balance
import com.exchanger.model.exception.InsufficientBalance
import com.exchanger.model.exception.InsufficientBalanceForCommission
import io.mockk.every
import io.mockk.justRun
import io.mockk.mockk
import io.mockk.verify
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class ExchangeDefaultUseCaseTest {

    private lateinit var balanceRepository: BalanceRepository
    private lateinit var exchangeRepository: ExchangeRepository
    private lateinit var exchangeUseCase: ExchangeDefaultUseCase

    @Before
    fun setUp() {
        balanceRepository = mockk()
        exchangeRepository = mockk()
        exchangeUseCase = ExchangeDefaultUseCase(balanceRepository, exchangeRepository)
    }

    @Test
    fun `invoke with sufficient balance and no fee`() = runBlocking {
        val currencySell = "EUR"
        val currencyReceive = "USD"
        val amountSell = 100.0
        val amountReceive = 85.0

        every { balanceRepository.getBalance(currencySell) } returns Balance(currencySell, 200.0)
        every { balanceRepository.getBalance(currencyReceive) } returns Balance(currencyReceive, 50.0)
        every { exchangeRepository.getExchangeCount() } returns 3
        justRun { balanceRepository.updateBalance(any(), any()) }
        justRun {
            runBlocking { exchangeRepository.incrementExchangeCount() }
        }

        val result = exchangeUseCase.invoke(currencySell, currencyReceive, amountSell, amountReceive)
        println(result)

        assertEquals(amountSell, result.amountSell, 0.0)
        assertEquals(amountReceive, result.amountReceive, 0.0)
        assertEquals(0.0, result.fee, 0.0)
        assertEquals(currencySell, result.currencySell)
        assertEquals(currencyReceive, result.currencyReceive)
        assertFalse(result.isFeeCharged)

        verify { balanceRepository.updateBalance(currencySell, 100.0) }
        verify { balanceRepository.updateBalance(currencyReceive, 135.0) }
        verify {
            runBlocking { exchangeRepository.incrementExchangeCount()  }
        }
    }

    @Test
    fun `invoke with sufficient balance and fee`() = runBlocking {
        val currencySell = "EUR"
        val currencyReceive = "USD"
        val amountSell = 100.0
        val amountReceive = 85.0

        every { balanceRepository.getBalance(currencySell) } returns Balance(currencySell, 200.0)
        every { balanceRepository.getBalance(currencyReceive) } returns Balance(currencyReceive, 50.0)
        every { exchangeRepository.getExchangeCount() } returns 6
        justRun { balanceRepository.updateBalance(any(), any()) }
        justRun {
            runBlocking { exchangeRepository.incrementExchangeCount() }
        }

        val result = exchangeUseCase.invoke(currencySell, currencyReceive, amountSell, amountReceive)

        assertEquals(amountSell, result.amountSell, 0.0)
        assertEquals(amountReceive, result.amountReceive, 0.0)
        assertEquals(0.7, result.fee, 0.0)
        assertEquals(currencySell, result.currencySell)
        assertEquals(currencyReceive, result.currencyReceive)
        assertTrue(result.isFeeCharged)

        verify { balanceRepository.updateBalance(currencySell, 99.3) }
        verify { balanceRepository.updateBalance(currencyReceive, 135.0) }
        verify {
            runBlocking { exchangeRepository.incrementExchangeCount() }
        }
    }

    @Test(expected = InsufficientBalance::class)
    fun `invoke with insufficient balance`() {
        runBlocking {
            val currencySell = "EUR"
            val currencyReceive = "USD"
            val amountSell = 100.0
            val amountReceive = 85.0

            every { balanceRepository.getBalance(currencySell) } returns Balance(currencySell, 50.0)
            every { balanceRepository.getBalance(currencyReceive) } returns Balance(currencyReceive, 65.0)

            exchangeUseCase.invoke(currencySell, currencyReceive, amountSell, amountReceive)
        }
    }

    @Test(expected = InsufficientBalanceForCommission::class)
    fun `invoke with insufficient balance for commission`() {
        runBlocking {
            val currencySell = "EUR"
            val currencyReceive = "USD"
            val amountSell = 100.0
            val amountReceive = 85.0

            every { balanceRepository.getBalance(currencySell) } returns Balance(currencySell, 100.3)
            every { balanceRepository.getBalance(currencyReceive) } returns Balance(currencyReceive, 50.0)
            every { exchangeRepository.getExchangeCount() } returns 7

            exchangeUseCase.invoke(currencySell, currencyReceive, amountSell, amountReceive)
        }
    }
}