package com.example.androidplayground.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidplayground.itemdetails.screen.ItemDetailsScreen
import com.example.androidplayground.main.screen.MainScreen

@Composable
fun MainNavigation(mainNavController: NavHostController = rememberNavController()) {

    NavHost(navController = mainNavController, startDestination = MainRoutes.Root.destination) {
        composable(route = MainRoutes.Root.destination) {
            MainScreen()
        }
        composable(route = MainRoutes.ItemDetails.destination) {
            ItemDetailsScreen(
                itemId = 1
            )
        }
    }
}
