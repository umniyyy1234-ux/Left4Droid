package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun GameLaunchScreen(
  profileName: String = "BALANCE",
  onBackPressed: () -> Unit
) {
  var status by remember { mutableStateOf("Подготовка среды...") }

  LaunchedEffect(Unit) {
    delay(1000)
    status = "Запуск Wine..."
    delay(1500)
    status = "Запуск L4D2..."
    delay(2000)
    status = "Игра запущена!"
  }

  Column(
    Modifier.fillMaxSize().padding(32.dp),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text("Профиль: $profileName", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.height(16.dp))
    Text(status, style = MaterialTheme.typography.bodyLarge)
    Spacer(Modifier.height(16.dp))
    Button(onClick = { onBackPressed() }) {
      Text("Назад")
    }
  }
}