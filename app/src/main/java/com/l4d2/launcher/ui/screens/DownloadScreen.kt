package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

@Composable
fun DownloadScreen(onDownloadComplete: () -> Unit) {
  var progress by remember { mutableStateOf(0f) }

  LaunchedEffect(Unit) {
    while (progress < 1f) {
      delay(50L)
      progress += 0.05f
    }
    onDownloadComplete()
  }

  Column(
    Modifier.fillMaxSize().padding(32.dp),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    LinearProgressIndicator(progress = { progress }, modifier = Modifier.fillMaxWidth())
    Spacer(Modifier.height(16.dp))
    Text("${(progress * 100).toInt()}% загружено")
  }
}