package com.example.androidplayground.itemdetails.navigation

import kotlinx.serialization.Serializable

sealed class ItemDetailsRoutes {
    @Serializable
    data class Root(val itemId: Int): ItemDetailsRoutes()
}
