package com.exchanger.model.exchange

data class ExchangeRate(
    val base: String = "",
    val date: String = "",
    val rates: List<Rate> = emptyList(),
)