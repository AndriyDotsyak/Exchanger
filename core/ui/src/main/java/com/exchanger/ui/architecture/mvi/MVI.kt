package com.exchanger.ui.architecture.mvi

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface MVI<State, Effect> {

    val state: StateFlow<State>
    val effect: Flow<Effect>

    fun initState(): State
    fun updateState(transformation: State.() -> State)
    fun publishEffect(effect: Effect)
}
