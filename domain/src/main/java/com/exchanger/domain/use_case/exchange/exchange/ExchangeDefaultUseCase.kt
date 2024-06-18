package com.exchanger.domain.use_case.exchange.exchange

import com.exchanger.data.repository.balance.BalanceRepository
import com.exchanger.data.repository.exchange.ExchangeRepository
import com.exchanger.model.exception.ExchangeAmountZero
import com.exchanger.model.exception.IdenticalСurrencies
import com.exchanger.model.exception.InsufficientBalance
import com.exchanger.model.exception.InsufficientBalanceForCommission
import com.exchanger.model.exchange.ExchangeResult
import javax.inject.Inject

class ExchangeDefaultUseCase @Inject constructor(
    private val balanceRepository: BalanceRepository,
    private val exchangeRepository: ExchangeRepository
) : ExchangeUseCase {

    override suspend fun invoke(
        currencySell: String,
        currencyReceive: String,
        amountSell: Double,
        amountReceive: Double
    ): ExchangeResult {
        when {
            currencySell == currencyReceive -> throw IdenticalСurrencies()
            amountSell == 0.0 -> throw ExchangeAmountZero()
        }

        val balanceSell = balanceRepository.getBalance(currencySell)?.balance ?: 0.0
        val balanceReceive = balanceRepository.getBalance(currencyReceive)?.balance ?: 0.0

        if (balanceSell >= amountSell) {
            val isFeeRequired = isFeeRequired()
            val exchangeFee = getExchangeFee(amountSell, isFeeRequired)
            val totalAmount = amountSell + exchangeFee

            if (balanceSell >= totalAmount) {
                val currentBalanceSell = balanceSell - totalAmount
                val currentBalanceReceive = balanceReceive + amountReceive

                balanceRepository.updateBalance(currencySell, currentBalanceSell)
                balanceRepository.updateBalance(currencyReceive, currentBalanceReceive)
                exchangeRepository.incrementExchangeCount()

                return ExchangeResult(
                    amountSell = amountSell,
                    amountReceive = amountReceive,
                    fee = exchangeFee,
                    currencySell = currencySell,
                    currencyReceive = currencyReceive,
                    isFeeCharged = isFeeRequired
                )
            } else {
                throw InsufficientBalanceForCommission()
            }
        } else {
            throw InsufficientBalance()
        }
    }

    private fun getExchangeFee(amount: Double, isFeeRequired: Boolean): Double {
        return if (isFeeRequired) {
            (amount.toBigDecimal() * RATE_EXCHANGE_FEE.toBigDecimal()).toDouble()
        } else 0.0
    }

    private fun isFeeRequired(): Boolean {
        return exchangeRepository.getExchangeCount() >= COUNT_FREE_EXCHANGE
    }

    companion object {
        private const val COUNT_FREE_EXCHANGE = 5
        private const val RATE_EXCHANGE_FEE = 0.007
    }
}