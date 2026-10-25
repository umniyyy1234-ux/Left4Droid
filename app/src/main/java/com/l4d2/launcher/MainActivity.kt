package com.l4d2.launcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import com.l4d2.launcher.ui.GameLauncherApp
import com.l4d2.launcher.ui.theme.L4D2LauncherTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      L4D2LauncherTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
          GameLauncherApp()
        }
      }
    }
  }
}