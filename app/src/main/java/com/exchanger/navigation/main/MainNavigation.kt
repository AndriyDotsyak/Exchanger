package com.exchanger.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import com.exchanger.ui.navigation.Navigator

private class MainNavigation(
    val navController: NavHostController
) : Navigator {

    override fun navigateUp() {
        navController.navigateUp()
    }

}

@Composable
fun rememberMainNavigator(
    navController: NavHostController
): Navigator {
    return remember {
        MainNavigation(navController = navController)
    }
}