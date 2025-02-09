package com.pravin.jetpackcompose

sealed class Destinations(val route: String) {
    data object FirstScreen : Destinations(route = "First Screen")
    data object SecondScreen : Destinations(route = "Second Screen")
}