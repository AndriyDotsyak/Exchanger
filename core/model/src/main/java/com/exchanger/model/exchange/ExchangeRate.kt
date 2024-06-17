package com.exchanger.model.exchange

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ExchangeRate(

    @SerialName("base")
    val base: String = "",

    @SerialName("date")
    val date: String = "",

    @SerialName("rates")
    val rates: Map<String, Double> = emptyMap(),

)