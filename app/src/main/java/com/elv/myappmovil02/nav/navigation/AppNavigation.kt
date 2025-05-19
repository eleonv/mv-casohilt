package com.elv.myappmovil02.nav.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elv.myappmovil02.nav.screens.DetailsScreen
import com.elv.myappmovil02.nav.screens.FirstScreen
import com.elv.myappmovil02.nav.screens.HomeScreen
import com.elv.myappmovil02.nav.screens.SecondScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HomeScreen.route) {
        composable(route = Routes.HomeScreen.route) { HomeScreen(navController) }
        composable(route = Routes.FirstScreen.route) { FirstScreen(navController) }
        composable(route = Routes.SecondScreen.route) { SecondScreen(navController) }
        composable(
            route = Routes.DetailScreen.route,
            arguments = listOf(navArgument("id") { type = NavType.StringType })
        ) { backStackEntry ->
            val idString = backStackEntry.arguments?.getString("id")
            val id = idString?.toIntOrNull()

            if (id != null) {
                DetailsScreen(navController, id)
            }
        }
    }
}