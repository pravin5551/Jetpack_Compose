package com.pravin.jetpackcompose.componants

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.pravin.jetpackcompose.Destinations
import com.pravin.jetpackcompose.screens.FirstScreen
import com.pravin.jetpackcompose.screens.SecondScreen

@Composable
fun DisplayScreen() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Destinations.FirstScreen.toString()) {
        composable(route = Destinations.FirstScreen.toString()) {
            FirstScreen(navController = navController, name = "Pravin")
        }
        composable(route = Destinations.SecondScreen.toString() + "/{textValue}") {
            val value = it.arguments?.getString("textValue")
            SecondScreen(navController = navController, name = value ?: "")
        }
    }
}