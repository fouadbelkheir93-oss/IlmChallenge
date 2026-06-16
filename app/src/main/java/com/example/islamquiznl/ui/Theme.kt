package com.example.islamquiznl.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// ── Colour palette ────────────────────────────────────────────────────────────
val NavyDeep     = Color(0xFF0A1628)
val NavyMid      = Color(0xFF0D2040)
val NavyLight    = Color(0xFF1A3A6B)
val GoldPrimary  = Color(0xFFD4AF37)
val GoldLight    = Color(0xFFF0D060)
val GoldDark     = Color(0xFFA07C20)
val GreenIslamic = Color(0xFF1B6B3A)
val GreenLight   = Color(0xFF2E9E55)
val WhiteSmoke   = Color(0xFFF5F5F0)
val OffWhite     = Color(0xFFEEEDE8)
val ErrorRed     = Color(0xFFD32F2F)
val SuccessGreen = Color(0xFF2E7D32)
val SurfaceDark  = Color(0xFF112038)

val DarkColorScheme = darkColorScheme(
    primary          = GoldPrimary,
    onPrimary        = NavyDeep,
    primaryContainer = NavyLight,
    onPrimaryContainer = GoldLight,
    secondary        = GreenIslamic,
    onSecondary      = WhiteSmoke,
    background       = NavyDeep,
    onBackground     = WhiteSmoke,
    surface          = SurfaceDark,
    onSurface        = WhiteSmoke,
    error            = ErrorRed,
    onError          = WhiteSmoke
)

val LightColorScheme = lightColorScheme(
    primary          = NavyLight,
    onPrimary        = WhiteSmoke,
    primaryContainer = OffWhite,
    onPrimaryContainer = NavyDeep,
    secondary        = GreenIslamic,
    onSecondary      = WhiteSmoke,
    background       = OffWhite,
    onBackground     = NavyDeep,
    surface          = WhiteSmoke,
    onSurface        = NavyDeep,
    error            = ErrorRed,
    onError          = WhiteSmoke
)

@Composable
fun IslamQuizTheme(darkTheme: Boolean = true, content: @Composable () -> Unit) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme
    MaterialTheme(colorScheme = colors, content = content)
}
