package com.portfolio.notes.ui.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.portfolio.notes.ui.theme.dimens

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    circleSize: Dp = 10.dp
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimens.spaceSmall)
    ) {
        repeat(pagerState.pageCount) { index ->
            val isSelected = pagerState.currentPage == index
            val fillColor = if (isSelected) MaterialTheme.colorScheme.onBackground else Color.Transparent
            val borderColor = if (!isSelected) MaterialTheme.colorScheme.onBackground else Color.Transparent
            val width by animateDpAsState(
                targetValue = if (isSelected) circleSize * 2 else circleSize,
                label = "Pager indicator width"
            )

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(fillColor)
                    .border(2.dp, borderColor, CircleShape)
                    .width(width)
                    .height(circleSize)
            )
        }
    }
}
