package com.exchanger.network.logger

import io.ktor.client.plugins.logging.Logger
import timber.log.Timber

internal class NetworkLogger : Logger {
    override fun log(message: String) {
        Timber.d(message = ">>>>>>>>>>>>>>>>>>>>>>>>>>> KTOR_MESSAGE [START] >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>")
        Timber.d(message = "Ktor $message")
        Timber.d(message = "<<<<<<<<<<<<<<<<<<<<<<<<<<< KTOR_MESSAGE [END] <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<")
    }
}
