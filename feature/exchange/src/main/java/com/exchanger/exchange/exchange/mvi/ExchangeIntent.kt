package com.exchanger.exchange.exchange.mvi

import androidx.compose.runtime.Stable
import com.exchanger.model.balance.Balance

@Stable
interface ExchangeIntent {

    fun onChangeAmountSell(amount: String)
    fun onChangeAmountReceive(amount: String)
    fun onChangeCurrencySell(balance: Balance)
    fun onChangeCurrencyReceive(balance: Balance)
    fun submit()

    companion object {
        val Empty: ExchangeIntent = EmptyExchangeIntent()
    }
}

private class EmptyExchangeIntent : ExchangeIntent {
    override fun onChangeAmountSell(amount: String) = Unit
    override fun onChangeAmountReceive(amount: String) = Unit
    override fun onChangeCurrencySell(balance: Balance) = Unit
    override fun onChangeCurrencyReceive(balance: Balance) = Unit
    override fun submit() = Unit
}