package com.exchanger.network.logger

import com.exchanger.core.network.BuildConfig
import io.ktor.client.plugins.logging.LogLevel

object NetworkLoggerConfig {

    fun getLogLevel(): LogLevel {
        return if (BuildConfig.DEBUG)
            LogLevel.ALL else LogLevel.NONE
    }

}
