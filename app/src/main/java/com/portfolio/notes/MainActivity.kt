package com.portfolio.notes

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.View
import android.view.animation.OvershootInterpolator
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.portfolio.notes.presentation.onboarding.OnboardingScreen
import com.portfolio.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        installSplashScreen().apply { setExitAnimation() }
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                val navController = rememberNavController()

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    contentWindowInsets = WindowInsets(0, 0, 0, 0)
                ) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(MaterialTheme.colorScheme.background)
                            .padding(innerPadding),
                        contentAlignment = Alignment.Center
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "onboarding"
                        ) {
                            composable("onboarding") {
                                OnboardingScreen(onNavigateUp = navController::navigateUp)
                            }
                        }
                    }
                }
            }
        }
    }

    private fun SplashScreen.setExitAnimation() {
        setOnExitAnimationListener { screen ->
            val zoomX = ObjectAnimator.ofFloat(
                screen.iconView,
                View.SCALE_X,
                0.4f,
                0.0f
            )
            zoomX.interpolator = OvershootInterpolator()
            zoomX.duration = 500L
            zoomX.doOnEnd { screen.remove() }

            val opacity = ObjectAnimator.ofFloat(
                screen.iconView,
                View.ALPHA,
                1f,
                0.0f
            )

            val zoomY = ObjectAnimator.ofFloat(
                screen.iconView,
                View.SCALE_Y,
                0.4f,
                0.0f
            )
            zoomY.interpolator = OvershootInterpolator()
            zoomY.duration = 500L
            zoomY.doOnEnd { screen.remove() }

            zoomX.start()
            zoomY.start()
            opacity.start()
        }
    }
}
