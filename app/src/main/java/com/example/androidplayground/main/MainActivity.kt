package com.example.androidplayground.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.androidplayground.designsystem.AndroidPlaygroundTheme
import com.example.androidplayground.main.navigation.MainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidPlaygroundTheme() {
                Scaffold(modifier = Modifier.fillMaxSize().safeDrawingPadding()) { _ ->
                    MainNavigation()
                }
            }
        }
    }
}
