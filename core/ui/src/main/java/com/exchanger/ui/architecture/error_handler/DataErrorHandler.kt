package com.exchanger.ui.architecture.error_handler

import com.exchanger.core.resource.R
import com.exchanger.model.exception.InsufficientBalance
import com.exchanger.model.exception.InsufficientBalanceForCommission
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import timber.log.Timber

class DataErrorHandler : ErrorHandler {

    private val errorChannel = MutableSharedFlow<DataError>()
    override val errorStream: Flow<DataError> = errorChannel

    override val handler = CoroutineExceptionHandler { _, throwable ->
        CoroutineScope(Dispatchers.IO).launch { handleError(throwable) }
    }

    private suspend fun handleError(exception: Throwable) {
        Timber.e(exception)

        when (exception) {
            is CancellationException -> return
            is InsufficientBalance -> errorChannel.emit(
                DataError.Resource(R.string.error_insufficient_balance)
            )
            is InsufficientBalanceForCommission -> errorChannel.emit(
                DataError.Resource(R.string.error_insufficient_balance_commission)
            )
            else -> errorChannel.emit(
                DataError.Message(exception.message.orEmpty())
            )
        }
    }

}
