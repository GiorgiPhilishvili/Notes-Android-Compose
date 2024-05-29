package com.portfolio.notes.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.graphics.Color

object AppColorPalette {
    val primary = Color(0xFF2E6DEC)

    val darkBackground = Color(0xFF161616)
    val darkSurface = Color(0xFF272727)

    val lightBackground = Color(0xFFF9F9F9)
    val lightSurface = Color(0xFFFFFFFF)

    // Text colors
    val darkOnBackground = Color(0xFFFFFFFF)
    val darkOnSurface = Color(0xFF909090)
    val lightOnBackground = Color(0xFF0E0E0E)
    val lightOnSurface = Color(0xFF6A7482)
}

data class Colors(
    val green: Color = Color(0xFF30AC2B),
    val purple: Color = Color(0xFF9049C8),
    val pink: Color = Color(0xFFFF595A)
)

val LocalColors = compositionLocalOf { Colors() }

val MaterialTheme.colors: Colors
    @Composable
    @ReadOnlyComposable
    get() = LocalColors.current
