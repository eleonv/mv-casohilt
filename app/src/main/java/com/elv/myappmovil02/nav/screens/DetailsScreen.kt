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
import com.elv.myappmovil02.nav.navigation.Routes

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun DetailsScreen(navController: NavController, id: Int) {
    //Scaffold { innerPadding -> SecondBodyContent(navController)}
    DetailBodyContent(navController, id)
}

@Composable
fun DetailBodyContent(navController: NavController, id: Int) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text("Details screen: $id")
        Button(onClick = {
            navController.navigate(Routes.HomeScreen.route)
        }) {
            Text("Ir a Home")
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun SecondDefaultPreview() {
    SecondScreen()
}*/