package com.example.androidplayground.login.navigation

import kotlinx.serialization.Serializable

sealed class LoginRoutes {
    @Serializable
    data object Root: LoginRoutes()
}