package com.l4d2.launcher.device

import android.os.Build
import android.util.Log

data class DeviceInfo(
  val soc: String,
  val gpu: String,
  val ramGb: Float,
  val androidVersion: String,
  val vulkanVersion: String?,
  val adrenoVersion: String?
)

object DeviceInfoProvider {
  private const val TAG = "DeviceInfoProvider"

  fun getDeviceInfo(): DeviceInfo {
    val soc = detectSoc()
    val gpu = detectGpu()
    val ramGb = detectRam()
    val androidVer = "Android ${Build.VERSION.SDK_INT}"
    val vulkan = detectVulkan()
    val adreno = detectAdreno()

    return DeviceInfo(
      soc = soc,
      gpu = gpu,
      ramGb = ramGb,
      androidVersion = androidVer,
      vulkanVersion = vulkan,
      adrenoVersion = adreno
    )
  }

  private fun detectSoc(): String {
    return try {
      val prop = Runtime.getRuntime().exec("getprop ro.product.board").inputStream.reader().readText().trim()
      prop.ifEmpty { "Unknown" }
    } catch (e: Exception) {
      "Unknown"
    }
  }

  private fun detectGpu(): String {
    return try {
      val prop = Runtime.getRuntime().exec("getprop ro.hardware.gpu").inputStream.reader().readText().trim()
      prop.ifEmpty { "Unknown" }
    } catch (e: Exception) {
      "Unknown"
    }
  }

  private fun detectRam(): Float {
    val totalBytes = Runtime.getRuntime().maxMemory()
    return totalBytes / (1024f * 1024f * 1024f)
  }

  private fun detectVulkan(): String? {
    return try {
      val prop = Runtime.getRuntime().exec("getprop ro.opengles.version").inputStream.reader().readText().trim()
      if (prop.contains("Vulkan")) prop else null
    } catch (e: Exception) {
      null
    }
  }

  private fun detectAdreno(): String? {
    return try {
      val prop = Runtime.getRuntime().exec("getprop ro.hardware").inputStream.reader().readText().trim()
      if (prop.contains("adreno") || prop.contains("snapdragon")) prop else null
    } catch (e: Exception) {
      null
    }
  }
}