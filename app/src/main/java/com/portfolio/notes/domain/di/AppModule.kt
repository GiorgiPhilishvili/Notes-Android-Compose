package com.portfolio.notes.domain.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.portfolio.notes.data.repository.PreferencesRepositoryImpl
import com.portfolio.notes.domain.repository.PreferencesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    // SharedPreferences
    @Provides
    @Singleton
    fun provideSharedPreferences(
        app: Application
    ): SharedPreferences {
        return app.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferencesRepository(
        sharedPreferences: SharedPreferences
    ): PreferencesRepository {
        return PreferencesRepositoryImpl(sharedPreferences)
    }
}
