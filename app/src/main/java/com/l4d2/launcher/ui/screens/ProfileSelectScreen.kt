package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

sealed class GameProfile(val name: String, val resolution: String, val textureQuality: String) {
  object MaxFPS : GameProfile("Максимум FPS", "1280x720", "Low")
  object Balance : GameProfile("Баланс", "1280x720", "Medium")
  object PowerSaving : GameProfile("Экономия энергии", "960x540", "Low")
  object Stability : GameProfile("Стабильность", "720x480", "Low")
}

@Composable
fun ProfileSelectScreen(
  onProfileSelected: (GameProfile) -> Unit,
  onSettingsClick: () -> Unit,
  onDiagnosticsClick: () -> Unit
) {
  val profiles = listOf(GameProfile.MaxFPS, GameProfile.Balance, GameProfile.PowerSaving, GameProfile.Stability)

  Column(Modifier.padding(16.dp)) {
    profiles.forEach { profile ->
      Card(
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        modifier = Modifier
          .fillMaxWidth()
          .padding(vertical = 4.dp)
          .clickable { onProfileSelected(profile) }
      ) {
        Column(Modifier.padding(16.dp)) {
          Text(profile.name, style = MaterialTheme.typography.titleMedium)
          Text("${profile.resolution} • ${profile.textureQuality} текстур", style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }
      }
    }

    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
      TextButton(onClick = { onSettingsClick() }) { Text("Настройки") }
      TextButton(onClick = { onDiagnosticsClick() }) { Text("Диагностика") }
    }
  }
}