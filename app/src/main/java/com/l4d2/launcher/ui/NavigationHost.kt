package com.l4d2.launcher.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

sealed class Screen(val route: String) {
  object Onboarding : Screen("onboarding")
  object SteamLogin : Screen("steam_login")
  object Download : Screen("download")
  object ProfileSelect : Screen("profile_select")
  object GameLaunch : Screen("game_launch")
  object Settings : Screen("settings")
  object Diagnostics : Screen("diagnostics")
}

@Composable
fun GameLauncherApp(
  modifier: Modifier = Modifier,
  navController: NavHostController = rememberNavController()
) {
  NavHost(
    navController = navController,
    startDestination = Screen.Onboarding.route,
    modifier = modifier
  ) {
    composable(Screen.Onboarding.route) {
      OnboardingScreen(onNext = { navController.navigate(Screen.SteamLogin.route) })
    }
    composable(Screen.SteamLogin.route) {
      SteamAuthScreen(
        onLoginSuccess = { navController.navigate(Screen.Download.route) },
        onSkip = { navController.navigate(Screen.ProfileSelect.route) }
      )
    }
    composable(Screen.Download.route) {
      DownloadScreen(onDownloadComplete = { navController.navigate(Screen.ProfileSelect.route) })
    }
    composable(Screen.ProfileSelect.route) {
      ProfileSelectScreen(
        onProfileSelected = { profile ->
          navController.currentBackStackEntry?.savedStateHandle?.set("profile", profile.name)
          navController.navigate(Screen.GameLaunch.route)
        },
        onSettingsClick = { navController.navigate(Screen.Settings.route) },
        onDiagnosticsClick = { navController.navigate(Screen.Diagnostics.route) }
      )
    }
    composable(Screen.GameLaunch.route) {
      GameLaunchScreen(
        onBackPressed = { navController.popBackStack() },
        profileName = navController.previousBackStackEntry?.savedStateHandle?.get<String>("profile") ?: "BALANCE"
      )
    }
    composable(Screen.Settings.route) {
      SettingsScreen(onBackPressed = { navController.popBackStack() })
    }
    composable(Screen.Diagnostics.route) {
      DiagnosticsScreen(onBackPressed = { navController.popBackStack() })
    }
  }
}