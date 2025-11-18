package com.example.androidplayground.main.screen

import androidx.compose.foundation.clickable
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    onItemClick: (Int) -> Unit = {}
) {
    Text(
        text = "Hello Android!",
        modifier = modifier.clickable {
            onItemClick(1)
        }
    )
}

@Composable
@Preview(showSystemUi = true)
fun ThisPreview() {
    MainScreen()
}