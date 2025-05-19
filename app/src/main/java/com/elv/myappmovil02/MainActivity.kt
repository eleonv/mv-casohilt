package com.elv.myappmovil02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
//import com.elv.myappmovil02.hilt.ProductService
import com.elv.myappmovil02.hilt.ProductViewModel
import com.elv.myappmovil02.nav.navigation.AppNavigation
import com.elv.myappmovil02.nav.screens.FirstScreen
import com.elv.myappmovil02.ui.theme.MyAppMovil02Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val productViewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //productViewModel.onCreate()

        setContent {
            MyAppMovil02Theme {
                //FirstScreen()
                AppNavigation()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyAppMovil02Theme {
        AppNavigation()
    }
}