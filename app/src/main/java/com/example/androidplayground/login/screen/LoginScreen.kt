package com.example.androidplayground.login.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androidplayground.common.data.AppDatabase
import com.example.androidplayground.designsystem.components.DefaultButton
import com.example.androidplayground.designsystem.components.DefaultTextField
import com.example.androidplayground.designsystem.components.InfoMessage
import com.example.androidplayground.designsystem.components.MessageType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

val emptyString by lazy { "" }

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit
) {
    val viewModel: LoginViewModel = viewModel()
    var username by remember { mutableStateOf(emptyString) }
    var password by remember { mutableStateOf(emptyString) }
    var showMessage by remember { mutableStateOf(false) }
    var messageType by remember { mutableStateOf(MessageType.ERROR) }
    var messageText by remember { mutableStateOf(emptyString) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
//        Box(modifier = Modifier.height(150.dp).width(150.dp).align(Alignment.CenterHorizontally)) {
//            Icon(tint = MaterialTheme.colorScheme.primary, imageVector = Icons.Default.ShoppingCart, contentDescription = null, modifier = Modifier.fillMaxSize())
//        }

        DefaultTextField(
            value = username,
            onValueChange = { username = it },
            label = "Usuario",
            placeholder = "Nombre de usuario",
            icon = {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        DefaultTextField(
            value = password,
            onValueChange = { password = it },
            label = "Contraseña",
            placeholder = "••••••••",
            isPassword = true,
            icon = {
                Icon(Icons.Default.Lock, contentDescription = null)
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = showMessage,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            InfoMessage(
                message = messageText,
                type = messageType
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        DefaultButton("Iniciar sesión") {
            showMessage = false
            val user = AppDatabase.fakeLoginUser(username, password)

            when {
                username.isEmpty() || password.isEmpty() -> {
                    messageText = "Ingrese usuario y contraseña"
                    messageType = MessageType.ERROR
                    showMessage = true
                }
                user != null -> {
                    coroutineScope.launch(Dispatchers.Main) {
                        messageText = "Login exitoso!"
                        messageType = MessageType.SUCCESS
                        showMessage = true
                        delay(1000)
                        viewModel.setActiveUser()
                        onLoginSuccess()
                    }
                }
                else -> {
                    messageText = "Usuario o contraseña invalida"
                    messageType = MessageType.ERROR
                    showMessage = true
                }
            }
        }
    }
}

@Composable
@Preview(showSystemUi = true)
fun LoginPreview() {
    LoginScreen {  }
}