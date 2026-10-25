package com.l4d2.launcher.steam

import android.util.Log
import java.io.File

object SteamCmdRunner {
  private const val TAG = "SteamCmdRunner"
  private const val INSTALL_DIR = "/storage/emulated/0/Android/data/com.l4d2.launcher/files/steamapps"

  fun installL4D2(username: String, password: String): Boolean {
    return try {
      val cmd = "steamcmd.sh +login $username $password +force_install_dir $INSTALL_DIR/left4dead2 +app_update 223010 validate +quit"
      val proc = ProcessBuilder("sh", "-c", cmd)
        .redirectErrorStream(true)
        .start()

      val result = proc.waitFor() == 0
      Log.d(TAG, "L4D2 install result: $result")
      result
    } catch (e: Exception) {
      Log.e(TAG, "Failed to install L4D2", e)
      false
    }
  }

  fun getInstallPath(): String = INSTALL_DIR
}