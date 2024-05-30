package com.portfolio.notes.presentation.onboarding

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.portfolio.notes.util.UiText
import java.util.UUID

data class OnboardingData(
    val id: String = UUID.randomUUID().toString(),
    val label: UiText,
    val message: UiText,
    @DrawableRes val imageId: Int,
    @StringRes val contentDescription: Int
)
