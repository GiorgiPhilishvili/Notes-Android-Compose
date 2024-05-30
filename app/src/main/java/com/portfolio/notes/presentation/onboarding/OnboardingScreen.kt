package com.portfolio.notes.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.portfolio.notes.R
import com.portfolio.notes.ui.components.PagerIndicator
import com.portfolio.notes.ui.theme.dimens
import com.portfolio.notes.util.UiEvent
import kotlinx.coroutines.launch

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(
    onNavigateUp: () -> Unit,
    viewModel: OnboardingViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState { viewModel.onboardingItems.size }

    LaunchedEffect(Unit) {
        viewModel.uiEvent.collect { event ->
            when (event) {
                is UiEvent.NavigateUp -> onNavigateUp()
                else -> Unit
            }
        }
    }

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .statusBarsPadding()
            .navigationBarsPadding()
            .padding(vertical = MaterialTheme.dimens.spaceMedium)
    ) {
        // Header
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.dimens.spaceMedium)
        ) {
            Text(
                text = stringResource(R.string.notes),
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.displaySmall
            )
            
            if (pagerState.currentPage != viewModel.onboardingItems.lastIndex) {
                Text(
                    text = stringResource(R.string.skip),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.clickable {
                        viewModel.onEvent(OnboardingEvent.OnDismiss)
                    }
                )
            }
        }

        // Content
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { index ->
            val onboardingData = viewModel.onboardingItems[index]

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(horizontal = MaterialTheme.dimens.spaceMedium)
            ) {
                Image(
                    painter = painterResource(onboardingData.imageId),
                    contentDescription = stringResource(onboardingData.contentDescription)
                )

                Spacer(Modifier.height(MaterialTheme.dimens.spaceMedium))

                Text(
                    text = onboardingData.label.asString(context),
                    color = MaterialTheme.colorScheme.onBackground,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.displaySmall
                )

                Spacer(Modifier.height(MaterialTheme.dimens.spaceSmall))

                Text(
                    text = onboardingData.message.asString(context),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center,
                    maxLines = 4,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }

        // Footer
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = MaterialTheme.dimens.spaceMedium),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            PagerIndicator(pagerState = pagerState)

            Text(
                text = stringResource(R.string.scroll_right).uppercase(),
                color = MaterialTheme.colorScheme.onSurface,
                letterSpacing = MaterialTheme.dimens.spaceExtraSmall.value.sp
            )

            IconButton(
                onClick = {
                    scope.launch {
                        if (pagerState.currentPage < viewModel.onboardingItems.size - 1) {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        } else if (pagerState.currentPage == viewModel.onboardingItems.size - 1) {
                            viewModel.onEvent(OnboardingEvent.OnDismiss)
                        }
                    }
                }
            ) {
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = stringResource(R.string.ic_arrow_right),
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        }
    }
}
