package com.exchanger.exchange.navigation_graph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.navigation
import com.exchanger.exchange.exchange.navigation.ROUTE_EXCHANGE
import com.exchanger.ui.navigation.Navigator
import com.exchanger.exchange.exchange.navigation.screenExchange

const val GRAPH_EXCHANGE = "graph_exchange"

fun NavGraphBuilder.graphExchange(
    navigator: Navigator
) {
    navigation(
        startDestination = ROUTE_EXCHANGE,
        route = GRAPH_EXCHANGE
    ) {
        screenExchange(navigator = navigator)
    }
}