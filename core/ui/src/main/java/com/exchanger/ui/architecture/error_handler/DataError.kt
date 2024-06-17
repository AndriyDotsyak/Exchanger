package com.exchanger.ui.architecture.error_handler

import androidx.annotation.StringRes

sealed class DataError {
    data class Message(val message: String): DataError()
    data class Resource(@StringRes val messageId: Int): DataError()
}
