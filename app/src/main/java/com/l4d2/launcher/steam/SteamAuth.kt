package com.l4d2.launcher.steam

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys

object SteamAuth {
  private const val PREF_NAME = "steam_auth"
  private const val KEY_STEAM_CREDENTIALS = "steam_credentials"

  fun saveCredentials(context: Context, username: String, password: String) {
    val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    val prefs = EncryptedSharedPreferences.create(
      PREF_NAME,
      masterKey,
      context,
      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
      EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    prefs.edit()
      .putString(KEY_STEAM_CREDENTIALS, "$username:$password")
      .apply()
  }

  fun getCredentials(context: Context): String? {
    val masterKey = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    val prefs = EncryptedSharedPreferences.create(
      PREF_NAME,
      masterKey,
      context,
      EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
      EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )
    return prefs.getString(KEY_STEAM_CREDENTIALS, null)
  }
}