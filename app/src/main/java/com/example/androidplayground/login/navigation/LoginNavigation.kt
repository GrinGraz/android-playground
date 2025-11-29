package com.example.androidplayground.login.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.androidplayground.login.screen.LoginScreen
import com.example.androidplayground.main.navigation.MainNavigation
import com.example.androidplayground.main.navigation.MainRoutes

@Composable
fun LoginNavigation(loginNavController: NavHostController = rememberNavController()) {

    NavHost(navController = loginNavController, startDestination = LoginRoutes.Root) {
        composable<LoginRoutes.Root> {
            LoginScreen(
                onLoginSuccess = {
                    loginNavController.navigate(MainRoutes.Root)
                }
            )
        }

        composable<MainRoutes.Root> {
            MainNavigation()
        }
    }
}
