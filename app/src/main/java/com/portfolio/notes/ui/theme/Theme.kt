package com.portfolio.notes.ui.theme

import android.app.Activity
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColorScheme(
    primary = AppColorPalette.primary,
    background = AppColorPalette.darkBackground,
    onBackground = AppColorPalette.darkOnBackground,
    surface = AppColorPalette.darkSurface,
    onSurface = AppColorPalette.darkOnSurface
)

private val LightColorScheme = lightColorScheme(
    primary = AppColorPalette.primary,
    background = AppColorPalette.lightBackground,
    onBackground = AppColorPalette.lightOnBackground,
    surface = AppColorPalette.lightSurface,
    onSurface = AppColorPalette.lightOnSurface
)

@Composable
fun NotesTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = Color.Transparent.toArgb()
            window.navigationBarColor = Color.Transparent.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    CompositionLocalProvider(
        LocalDimensions provides Dimensions(),
        LocalColors provides Colors()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            shapes = Shapes,
            content = content
        )
    }
}
