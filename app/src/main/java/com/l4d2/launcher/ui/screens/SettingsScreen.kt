package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen(onBackPressed: () -> Unit) {
  Column(Modifier.padding(16.dp)) {
    Text("Настройки", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.height(16.dp))

    Button(onClick = { /* TODO: Open Termux settings */ }) {
      Text("Настройки Termux")
    }

    Button(onClick = { /* TODO: Reset configs */ }) {
      Text("Сбросить конфигурацию")
    }

    Spacer(Modifier.height(16.dp))
    Button(onClick = { onBackPressed() }) {
      Text("Назад")
    }
  }
}