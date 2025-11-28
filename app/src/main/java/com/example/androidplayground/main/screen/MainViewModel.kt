package com.example.androidplayground.main.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.common.data.AppDatabase
import com.example.androidplayground.common.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    val database = AppDatabase
    var items = MutableStateFlow<List<Item>>(listOf())
        private set

    suspend fun getItems() {
        viewModelScope.launch {
            val fakeItems = database.getFakeItems()
            items.value = fakeItems
        }
    }
}