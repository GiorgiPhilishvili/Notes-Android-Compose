package com.portfolio.notes.util

sealed class UiEvent {
    data class Navigate(
        val route: String,
        val clearBackStack: Boolean = false
    ): UiEvent()

    data object NavigateUp: UiEvent()
    data class ShowToast(val message: UiText): UiEvent()

    data object ChangePagerState: UiEvent()
}
