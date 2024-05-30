package com.portfolio.notes.presentation.onboarding

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.portfolio.notes.R
import com.portfolio.notes.domain.repository.PreferencesRepository
import com.portfolio.notes.util.UiEvent
import com.portfolio.notes.util.UiText
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val preferences: PreferencesRepository
): ViewModel() {
    private var state by mutableStateOf(OnboardingState())

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    val onboardingItems = listOf(
        OnboardingData(
            label = UiText.StringResource(R.string.onboarding_title_1),
            message = UiText.StringResource(R.string.onboarding_message_1),
            imageId = R.drawable.img_onboarding_1,
            contentDescription = R.string.onboarding_title_1
        ),
        OnboardingData(
            label = UiText.StringResource(R.string.onboarding_title_1),
            message = UiText.StringResource(R.string.onboarding_message_1),
            imageId = R.drawable.img_onboarding_1,
            contentDescription = R.string.onboarding_title_1
        ),
        OnboardingData(
            label = UiText.StringResource(R.string.onboarding_title_1),
            message = UiText.StringResource(R.string.onboarding_message_1),
            imageId = R.drawable.img_onboarding_1,
            contentDescription = R.string.onboarding_title_1
        )
    )

    fun onEvent(event: OnboardingEvent) {
        viewModelScope.launch {
            when (event) {
                is OnboardingEvent.OnDismiss -> {
                    state = state.copy(dismiss = true)
                    preferences.saveShouldShowOnboarding(false)
                    _uiEvent.send(UiEvent.ChangePagerState)
                }
            }
        }
    }
}
