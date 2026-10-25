package com.l4d2.launcher.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnboardingScreen(onNext: () -> Unit) {
  val pages = listOf(
    Triple("Добро пожаловать", "Запуск L4D2 на Android через слой совместимости Wine/Proton"),
    Triple("Steam Login", "Вход через Steam для загрузки игры"),
    Triple("Готово к запуску", "Одним кликом начните играть!")
  )

  val pagerState = rememberPagerState(pageCount = { pages.size })

  Column(Modifier.fillMaxSize()) {
    HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
      val (title, desc) = pages[page]
      Column(
        Modifier.padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
      ) {
        Text(title, style = MaterialTheme.typography.headlineMedium)
        Spacer(Modifier.height(16.dp))
        Text(desc, style = MaterialTheme.typography.bodyLarge)
      }
    }

    Button(
      onClick = {
        if (pagerState.currentPage < pages.size - 1) {
          // Next page logic handled by pager control
        } else {
          onNext()
        }
      },
      Modifier.fillMaxWidth().padding(16.dp)
    ) {
      Text(if (pagerState.currentPage < pages.size - 1) "Далее" else "Начать")
    }
  }
}