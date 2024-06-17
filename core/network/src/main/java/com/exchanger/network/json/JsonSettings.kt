package com.exchanger.network.json

import kotlinx.serialization.json.Json

object JsonSettings {

    fun getDefaultSettings() = Json {
        prettyPrint = true
        isLenient = true
        ignoreUnknownKeys = true
        encodeDefaults = true
    }

}