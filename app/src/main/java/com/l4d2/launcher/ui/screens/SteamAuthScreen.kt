package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SteamAuthScreen(
  onLoginSuccess: () -> Unit,
  onSkip: () -> Unit
) {
  var username by remember { mutableStateOf("") }
  var password by remember { mutableStateOf("") }

  Column(Modifier.padding(32.dp)) {
    Text("Вход через Steam", style = MaterialTheme.typography.headlineMedium)
    Spacer(Modifier.height(16.dp))

    OutlinedTextField(
      value = username,
      onValueChange = { username = it },
      label = { Text("Имя пользователя Steam") },
      singleLine = true,
      modifier = Modifier.fillMaxWidth()
    )

    OutlinedTextField(
      value = password,
      onValueChange = { password = it },
      label = { Text("Пароль") },
      singleLine = false,
      visualTransformation = PasswordVisualTransformation(),
      keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
      modifier = Modifier.fillMaxWidth()
    )

    Spacer(Modifier.height(16.dp))

    Button(
      onClick = { onLoginSuccess() },
      modifier = Modifier.fillMaxWidth()
    ) {
      Text("Войти")
    }

    TextButton(onClick = { onSkip() }) {
      Text("Пропустить (импорт файлов вручную)")
    }
  }
}