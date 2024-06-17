package com.exchanger.screen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.exchanger.exchange.navigation_graph.GRAPH_EXCHANGE
import com.exchanger.navigation.main.MainNavHost
import com.exchanger.navigation.main.rememberMainNavigator
import com.exchanger.ui.theme.Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            val navController = rememberNavController()
            val navigator = rememberMainNavigator(
                navController = navController
            )

            Theme(activity = this) {
                MainNavHost(
                    startScreen = GRAPH_EXCHANGE,
                    navController = navController,
                    navigator = navigator
                )
            }
        }
    }

}