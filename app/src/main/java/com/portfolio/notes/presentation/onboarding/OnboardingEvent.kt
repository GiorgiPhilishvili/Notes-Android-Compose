package com.portfolio.notes.presentation.onboarding

sealed class OnboardingEvent {
    data object OnDismiss: OnboardingEvent()
}
