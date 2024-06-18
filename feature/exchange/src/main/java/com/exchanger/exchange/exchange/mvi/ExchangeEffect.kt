package com.exchanger.exchange.exchange.mvi

sealed class ExchangeEffect {
    data class ShowToast(val message: String) : ExchangeEffect()
    data class ShowToastResource(val resource: Int) : ExchangeEffect()
}