package com.example.androidplayground.main.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(
    modifier: Modifier = Modifier
) {
    Text(
        text = "Hello Android!",
        modifier = modifier
    )
}