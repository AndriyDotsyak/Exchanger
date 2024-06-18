package com.exchanger.exchange.exchange.navigation

import android.widget.Toast
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.exchanger.exchange.exchange.ExchangeScreen
import com.exchanger.exchange.exchange.ExchangeViewModel
import com.exchanger.exchange.exchange.mvi.ExchangeEffect
import com.exchanger.exchange.exchange.dialog.ExchangeSuccessDialog
import com.exchanger.ui.navigation.Navigator

internal const val ROUTE_EXCHANGE = "Exchange"

fun NavGraphBuilder.screenExchange(
    navigator: Navigator
) {
    composable(route = ROUTE_EXCHANGE) {
        val viewModel = hiltViewModel<ExchangeViewModel>()
        val state = viewModel.state.collectAsStateWithLifecycle()
        val context = LocalContext.current

        LaunchedEffect(Unit) {
            viewModel.effect.collect { effect ->
                when (effect) {
                    is ExchangeEffect.ShowToast -> {
                        Toast.makeText(context, effect.message, Toast.LENGTH_LONG).show()
                    }
                    is ExchangeEffect.ShowToastResource -> {
                        Toast.makeText(context, effect.resource, Toast.LENGTH_LONG).show()
                    }
                }
            }
        }

        ExchangeScreen(
            state = state.value,
            intent = viewModel,
            navigator = navigator
        )

        ExchangeSuccessDialog(
            data = state.value.exchangeResult,
            isVisible = state.value.isVisibleSuccessDialog,
            onDismiss = viewModel::hideSuccessDialog
        )
    }
}

fun NavController.navigateToExchange(navOptions: NavOptions? = null) {
    navigate(ROUTE_EXCHANGE, navOptions)
}