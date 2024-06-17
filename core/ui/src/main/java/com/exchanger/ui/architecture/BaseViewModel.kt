package com.exchanger.ui.architecture

import com.exchanger.ui.architecture.error_handler.DataErrorHandler
import com.exchanger.ui.architecture.error_handler.ErrorHandler
import com.exchanger.ui.architecture.mvi.ModelViewIntent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class BaseViewModel<State, Effect> : ModelViewIntent<State, Effect>(),
    ErrorHandler by DataErrorHandler() {

    val viewModelScope: CoroutineScope by lazy {
        CoroutineScope(SupervisorJob() + Dispatchers.IO + handler)
    }

    override fun onCleared() {
        super.onCleared()

        viewModelScope.cancel()
    }
}