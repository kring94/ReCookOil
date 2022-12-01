package com.example.recookoil.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = PrimaryLight,
    primaryVariant = Primary,
    secondary = SecondaryLight,
    onPrimary = White,
    error = Red200
)

private val LightColorPalette = lightColors(
    primary = PrimaryDark,
    primaryVariant = Primary,
    secondary = Secondary,
    onSecondary = White,
    error = Red800

)

@Composable
fun ReCookOilTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = ReCookOilTypography,
        shapes = Shapes,
        content = content
    )
}