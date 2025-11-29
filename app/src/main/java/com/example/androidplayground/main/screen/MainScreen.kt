package com.example.androidplayground.main.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidplayground.designsystem.components.ItemCard

@Composable
fun MainScreen(
    onItemClick: (Int) -> Unit = {}
) {
    val viewModel: MainViewModel = viewModel()

    val items = viewModel.items.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getItems()
    }

    LazyColumn {
        items(items.value) { item ->
            ItemCard(
                item = item,
                onItemClick = {
                    onItemClick(item.id)
                }
            )
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun ThisPreview() {
    MainScreen()
}