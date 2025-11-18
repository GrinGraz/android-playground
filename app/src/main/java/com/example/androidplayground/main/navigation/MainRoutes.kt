package com.example.androidplayground.main.navigation

sealed class MainRoutes(val destination: String) {
    data object Root: MainRoutes(destination = "root")
    data object ItemDetails: MainRoutes(destination = "itemDetails")
}