package com.exchanger.ui.architecture.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

abstract class ModelViewIntent<State, Effect> : ViewModel(), MVI<State, Effect> {

    private val initialState: State by lazy { initState() }
    private val stateFlow = MutableStateFlow(initialState)
    override val state: StateFlow<State> = stateFlow.asStateFlow()

    private val effectChannel = Channel<Effect>(Channel.BUFFERED)
    override val effect: Flow<Effect> = effectChannel.receiveAsFlow()

    override fun updateState(transformation: State.() -> State) {
        stateFlow.update { currentState ->
            transformation(currentState)
        }
    }

    override fun publishEffect(effect: Effect) {
        viewModelScope.launch { effectChannel.send(effect) }
    }

}
