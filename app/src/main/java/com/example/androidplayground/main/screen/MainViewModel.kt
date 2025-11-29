package com.example.androidplayground.main.screen

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidplayground.common.data.AppDatabase
import com.example.androidplayground.common.data.Item
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val database = AppDatabase

    private val _items = MutableStateFlow<List<Item>>(listOf())
    val items: StateFlow<List<Item>> get() = _items


    suspend fun getItems() {
        viewModelScope.launch {
            val fakeItems = database.getFakeItems()
            _items.value = fakeItems
        }
    }
}