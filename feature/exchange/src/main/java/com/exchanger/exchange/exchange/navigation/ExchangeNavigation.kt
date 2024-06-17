package com.exchanger.exchange.exchange.navigation

import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.exchanger.exchange.exchange.ExchangeScreen
import com.exchanger.exchange.exchange.ExchangeViewModel
import com.exchanger.ui.navigation.Navigator

internal const val ROUTE_EXCHANGE = "Exchange"

fun NavGraphBuilder.screenExchange(
    navigator: Navigator
) {
    composable(route = ROUTE_EXCHANGE) {
        val viewModel = hiltViewModel<ExchangeViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()

        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->
                // TODO Handle effect
            }
        }

        ExchangeScreen(
            state = state.value,
            intent = viewModel,
            navigator = navigator
        )
    }
}

fun NavController.navigateToExchange(navOptions: NavOptions? = null) {
    navigate(ROUTE_EXCHANGE, navOptions)
}