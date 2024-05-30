package com.portfolio.notes.data.repository

import android.content.SharedPreferences
import com.portfolio.notes.domain.model.Theme
import com.portfolio.notes.domain.repository.PreferencesRepository

class PreferencesRepositoryImpl(
    private val sharedPreferences: SharedPreferences
): PreferencesRepository {
    // Theme
    override fun saveTheme(theme: Theme) {
        sharedPreferences
            .edit()
            .putString(PreferencesRepository.KEY_THEME, theme.name)
            .apply()
    }

    override fun getTheme(): Theme {
        val themeString = sharedPreferences
            .getString(PreferencesRepository.KEY_THEME, Theme.SYSTEM.name)

        return Theme.valueOf(themeString ?: Theme.SYSTEM.name)
    }

    // Onboarding
    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPreferences
            .edit()
            .putBoolean(PreferencesRepository.KEY_SHOULD_SHOW_ONBOARDING, shouldShow)
            .apply()
    }

    override fun getShouldShowOnboarding(): Boolean {
        return sharedPreferences
            .getBoolean(PreferencesRepository.KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}
