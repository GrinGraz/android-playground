package com.example.androidplayground.itemdetails.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ItemDetailsScreen(itemId: Int, modifier: Modifier = Modifier) {
    Text(
        text = "Item Screen $itemId",
        modifier = modifier
    )
}


@Composable
@Preview(showSystemUi = true)
fun ThisPreview() {
    ItemDetailsScreen(itemId = 1)
}