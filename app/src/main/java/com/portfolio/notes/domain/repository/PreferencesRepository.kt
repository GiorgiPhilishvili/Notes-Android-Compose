package com.portfolio.notes.domain.repository

import com.portfolio.notes.domain.model.Theme

interface PreferencesRepository {
    companion object {
        const val KEY_THEME = "theme"
        const val KEY_SHOULD_SHOW_ONBOARDING = "should_show_onboarding"
    }

    fun saveTheme(theme: Theme)
    fun getTheme(): Theme

    fun saveShouldShowOnboarding(shouldShow: Boolean)
    fun getShouldShowOnboarding(): Boolean
}
