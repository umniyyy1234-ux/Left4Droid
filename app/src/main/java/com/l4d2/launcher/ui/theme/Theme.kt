package com.l4d2.launcher.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColorScheme(
  primary = androidx.compose.ui.graphics.Color(0xFFE63946),
  secondary = androidx.compose.ui.graphics.Color(0xFFA8DADC),
  tertiary = androidx.compose.ui.graphics.Color(0xFF457B9D),
  background = androidx.compose.ui.graphics.Color(0xFF1D3557),
  surface = androidx.compose.ui.graphics.Color(0xFF1D3557)
)

@Composable
fun L4D2LauncherTheme(content: @Composable () -> Unit) {
  MaterialTheme(
    colorScheme = DarkColorScheme,
    typography = Typography(),
    content = content
  )
}