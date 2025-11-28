package com.example.androidplayground.main.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.androidplayground.itemdetails.navigation.ItemDetailsRoutes
import com.example.androidplayground.itemdetails.screen.ItemDetailsScreen
import com.example.androidplayground.main.screen.MainScreen

@Composable
fun MainNavigation(mainNavController: NavHostController = rememberNavController()) {

    NavHost(navController = mainNavController, startDestination = MainRoutes.Root) {
        composable<MainRoutes.Root> {
            MainScreen(
                onItemClick = { itemId ->
                    mainNavController.navigate(ItemDetailsRoutes.Root(itemId))
                }
            )
        }

        composable<ItemDetailsRoutes.Root> { backstackEntry ->
            val item: ItemDetailsRoutes.Root = backstackEntry.toRoute()
            ItemDetailsScreen(
                itemId = item.itemId
            )
        }
    }
}
