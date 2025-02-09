package com.pravin.jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.pravin.jetpackcompose.Destinations


@Composable
fun SecondScreen(navController: NavController, name: String? = null) {
    Column {
        Text("Welcome to Second Screen! - $name", modifier = Modifier.padding(16.dp), fontSize = 24.sp)

        Button(
            onClick = {
                navController.popBackStack(Destinations.FirstScreen.toString(), inclusive = true)
            },
        ) {
            Text("Navigate to First Screen")
        }
    }
}