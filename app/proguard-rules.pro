# Add project specific ProGuard rules here.
# Keep all Compose classes
-keep class androidx.compose.**
-keep class kotlin.Metadata

# Keep our classes
-keep class com.l4d2.launcher.**

# Keep Kotlin coroutines
-dontwarn kotlinx.coroutines.**

# Keep Compose runtime
-keep class androidx.compose.runtime.snapshots.**