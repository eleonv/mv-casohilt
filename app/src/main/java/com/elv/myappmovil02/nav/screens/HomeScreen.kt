package com.elv.myappmovil02.nav.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.elv.myappmovil02.nav.navigation.Routes

@Composable
fun HomeScreen(navController: NavController) {
    //Scaffold { innerPadding -> SecondBodyContent(navController)}
    HomeBodyContent(navController)
}

@Composable
fun HomeBodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Home Screen")
        Button(onClick = {
            navController.navigate(Routes.FirstScreen.route)
        }) {
            Text("Navega first screen")
        }
    }
}