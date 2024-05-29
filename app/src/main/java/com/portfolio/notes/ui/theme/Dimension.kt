package com.portfolio.notes.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Dimensions(
    val default: Dp = 0.dp,
    val spaceExtraSmall: Dp = 4.dp,
    val spaceSmall: Dp = 8.dp,
    val spaceMedium: Dp = 16.dp,
    val spaceLarge: Dp = 32.dp,
    val spaceExtraLarge: Dp = 64.dp,

    val paddingExtraSmall: Dp = 2.dp,
    val paddingSmall: Dp = 6.dp,
    val paddingMedium: Dp = 12.dp,
    val paddingLarge: Dp = 10.dp,
    val paddingLarger: Dp = 18.dp,
    val paddingExtraLarge: Dp = 20.dp,
    val paddingExtraLarge2: Dp = 25.dp
)

val LocalDimensions = compositionLocalOf { Dimensions() }

val MaterialTheme.dimens: Dimensions
    @Composable
    @ReadOnlyComposable
    get() = LocalDimensions.current
