package com.l4d2.launcher.orchestrator

import java.io.File

object WineRunner {
  private const val WINE_PREFIX = "/data/data/com.termux/files/usr/var/lib/wine"
  private const val GAME_PATH = "/storage/emulated/0/Android/data/com.l4d2.launcher/files/steamapps/common/left4dead2"

  fun launchGame(profile: String, resolution: String) {
    try {
      val script = """
        export WINEPREFIX=$WINE_PREFIX
        cd $GAME_PATH
        wine left4dead2.exe -w ${resolution.split("x")[0]} -h ${resolution.split("x")[1]}
      """.trimIndent()

      val proc = ProcessBuilder("sh", "-c", script)
        .redirectErrorStream(true)
        .start()

      proc.waitFor()
    } catch (e: Exception) {
      e.printStackTrace()
    }
  }
}