package com.exchanger.ui.architecture.error_handler

import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.Flow

interface ErrorHandler {

    val errorStream: Flow<DataError>
    val handler: CoroutineExceptionHandler
}
