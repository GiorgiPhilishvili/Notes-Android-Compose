package com.portfolio.notes.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = Typography(
    // Display
    displayLarge = TextStyle(
        fontSize = 40.sp,
        fontWeight = FontWeight.Medium,
    ),
    displayMedium = TextStyle(
        fontSize = 22.sp,
        fontWeight = FontWeight.Medium
    ),
    displaySmall = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),
    // Headline
    headlineLarge = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Medium
    ),
    headlineMedium = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal
    ),
    headlineSmall = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),
    // Title
    // Body
    bodyLarge = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyMedium = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    // Label
    labelLarge = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Medium
    ),
    labelMedium = TextStyle(
        fontSize = 12.sp,
        fontWeight = FontWeight.Normal
    ),
    labelSmall = TextStyle(
        fontSize = 10.sp,
        fontWeight = FontWeight.Normal
    )
)
