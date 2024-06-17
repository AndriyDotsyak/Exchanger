package com.exchanger.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.exchanger.exchange.navigation_graph.graphExchange
import com.exchanger.ui.navigation.Navigator

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    startScreen: String,
    navController: NavHostController,
    navigator: Navigator
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startScreen
    ) {
        graphExchange(navigator)
    }
}