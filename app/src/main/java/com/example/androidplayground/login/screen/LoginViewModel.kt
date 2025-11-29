package com.example.androidplayground.login.screen

import androidx.lifecycle.ViewModel
import com.example.androidplayground.common.data.AppDatabase

class LoginViewModel: ViewModel() {
    val database = AppDatabase

    fun setActiveUser() {
        database.setActiveUser()
    }
}