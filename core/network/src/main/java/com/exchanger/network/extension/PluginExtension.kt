package com.exchanger.network.extension

import com.exchanger.network.json.JsonSettings
import com.exchanger.network.logger.NetworkLogger
import com.exchanger.network.logger.NetworkLoggerConfig
import com.exchanger.network.util.NetworkConstants
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.android.AndroidEngineConfig
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json

internal fun HttpClientConfig<AndroidEngineConfig>.installJson() {
    install(plugin = ContentNegotiation) {
        json(json = JsonSettings.getDefaultSettings())
    }
}

internal fun HttpClientConfig<AndroidEngineConfig>.installHttpTimeout() {
    install(plugin = HttpTimeout) {
        requestTimeoutMillis = NetworkConstants.Timeout.REQUEST
        connectTimeoutMillis = NetworkConstants.Timeout.CONNECTION
    }
}

internal fun HttpClientConfig<AndroidEngineConfig>.installLogging() {
    install(plugin = Logging) {
        logger = NetworkLogger()
        level = NetworkLoggerConfig.getLogLevel()
    }
}