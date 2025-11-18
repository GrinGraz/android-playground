package com.example.androidplayground.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavigation(mainNavController: NavHostController) {

    NavHost(navController = mainNavController, startDestination = "") {
        TODO("Add main screen navigation routes")
    }
}