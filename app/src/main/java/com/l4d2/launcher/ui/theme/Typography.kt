package com.l4d2.launcher.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.google.GoogleFont
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

val GoogleFonts = GoogleFont("Roboto")

val BodyFontFamily = FontFamily(
  FontFamily.WeightStyle(FontFamily.SansSerif, 400, 700)
)

val Typography = Typography(
  bodyLarge = TextStyle(
    fontFamily = BodyFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 16.sp
  ),
  titleLarge = TextStyle(
    fontFamily = BodyFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 24.sp
  ),
  headlineMedium = TextStyle(
    fontFamily = BodyFontFamily,
    fontWeight = FontWeight.Bold,
    fontSize = 28.sp
  )
)

@Composable
fun Typography(): Typography {
  val googleFont = GoogleFont("Roboto")
  return Typography(
    bodyLarge = TextStyle(
      fontFamily = Family(googleFont),
      fontWeight = FontWeight.Normal,
      fontSize = 16.sp
    )
  )
}