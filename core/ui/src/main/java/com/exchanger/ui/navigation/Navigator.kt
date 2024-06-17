package com.exchanger.ui.navigation

import androidx.compose.runtime.Stable

@Stable
interface Navigator {

    fun navigateUp()

    companion object {
        val Empty: Navigator = EmptyNavigator()
    }
}

private class EmptyNavigator : Navigator {
    override fun navigateUp() = Unit
}