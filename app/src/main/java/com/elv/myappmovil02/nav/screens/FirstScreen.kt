package com.elv.myappmovil02.nav.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun FirstScreen(navController: NavController) {
    //Scaffold { innerPadding -> BodyContent(navController)}
    BodyContent(navController)
}

@Composable
fun BodyContent(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Hola Navegación first")
        Button(onClick = {
            //navController.navigate("second_screen")
            navController.navigate("second_screen")
        }) {
            Text("Navega second screen")
        }

        Button(onClick = {
            //navController.navigate("second_screen")
            var id = 6
            navController.navigate("detail_screen/$id")
        }) {
            Text("Ver detalles")
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FirstScreen()
}*/