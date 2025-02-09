package com.pravin.jetpackcompose.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.pravin.jetpackcompose.Destinations

@Composable
fun FirstScreen(navController: NavController, name: String, initialTextValue: String? = null) {
    var textValue by remember { mutableStateOf(initialTextValue ?: "") }
    Column {
        Text("Hello, $name!", modifier = Modifier.padding(16.dp))
        TextField(value = textValue, onValueChange = { value -> textValue = value }, label = { Text("Enter your name") })
        Button(
            onClick = {
                navController.navigate(Destinations.SecondScreen.toString() + "/$textValue")
            },
        ) {
            Text("Click Me!")
        }
    }
}