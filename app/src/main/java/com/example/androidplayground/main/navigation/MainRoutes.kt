package com.example.androidplayground.main.navigation

import kotlinx.serialization.Serializable

sealed class MainRoutes {
    @Serializable
    data object Root: MainRoutes()
    protected data object Cart: MainRoutes()
}