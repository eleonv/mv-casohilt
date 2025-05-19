package com.elv.myappmovil02.nav.navigation

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

sealed class Routes (val route: String) {
    object HomeScreen: Routes("home")
    object FirstScreen: Routes("first_screen")
    object SecondScreen: Routes("second_screen")
    object DetailScreen: Routes("detail_screen/{id}") {
        fun createRoute(id: Int) = "detail_screen/$id"
    }
}