package com.example.androidplayground.itemdetails.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ItemDetailsScreen(itemId: Int, modifier: Modifier) {
    Text(
        text = "Item Screen $itemId",
        modifier = modifier
    )
}