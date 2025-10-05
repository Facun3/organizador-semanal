package com.organizadorsemanal.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorScheme = darkColors(
    primary = androidx.compose.ui.graphics.Color(0xFFD0BCFF),
    secondary = androidx.compose.ui.graphics.Color(0xFFCCC2DC)
)

private val LightColorScheme = lightColors(
    primary = androidx.compose.ui.graphics.Color(0xFF6650a4),
    secondary = androidx.compose.ui.graphics.Color(0xFF625b71)
)

@Composable
fun OrganizadorSemanalTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
}