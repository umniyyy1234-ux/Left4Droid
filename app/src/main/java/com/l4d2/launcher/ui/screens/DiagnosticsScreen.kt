package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DiagnosticsScreen(onBackPressed: () -> Unit) {
  Column(Modifier.padding(16.dp)) {
    Text("Диагностика", style = MaterialTheme.typography.titleLarge)
    Spacer(Modifier.height(16.dp))

    Text("SoC: Snapdragon 8 Gen 3 / Adreno 750")
    Text("Android: 14")
    Text("RAM: 12GB")
    Text("Vulkan: 1.3")

    Spacer(Modifier.height(16.dp))
    Button(onClick = { /* TODO: Export logs */ }) {
      Text("Экспорт логов")
    }

    Spacer(Modifier.height(16.dp))
    Button(onClick = { onBackPressed() }) {
      Text("Назад")
    }
  }
}