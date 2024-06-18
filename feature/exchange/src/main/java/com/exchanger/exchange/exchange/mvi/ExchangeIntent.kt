package com.exchanger.exchange.exchange.mvi

import androidx.compose.runtime.Stable
import com.exchanger.model.exchange.Rate

@Stable
interface ExchangeIntent {

    fun onChangeAmountSell(amount: String)
    fun onChangeCurrencySell(currency: Rate)
    fun onChangeCurrencyReceive(currency: Rate)
    fun hideSuccessDialog()
    fun submit()

    companion object {
        val Empty: ExchangeIntent = EmptyExchangeIntent()
    }
}

private class EmptyExchangeIntent : ExchangeIntent {
    override fun onChangeAmountSell(amount: String) = Unit
    override fun onChangeCurrencySell(currency: Rate) = Unit
    override fun onChangeCurrencyReceive(currency: Rate) = Unit
    override fun hideSuccessDialog() = Unit
    override fun submit() = Unit
}