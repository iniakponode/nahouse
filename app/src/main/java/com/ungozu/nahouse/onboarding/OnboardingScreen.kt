package com.ungozu.nahouse.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.HorizontalPagerIndicator
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(viewModel: OnboardingViewModel, onFinish: () -> Unit) {
    if (viewModel.isCompleted()) {
        LaunchedEffect(Unit) { onFinish() }
        return
    }
    val items = listOf(
        OnboardingItem(
            imageRes = com.ungozu.nahouse.R.drawable.ic_launcher_foreground,
            title = "Find Homes",
            description = "Search and discover your next home"
        ),
        OnboardingItem(
            imageRes = com.ungozu.nahouse.R.drawable.ic_launcher_foreground,
            title = "Connect",
            description = "Chat with landlords and roommates"
        ),
        OnboardingItem(
            imageRes = com.ungozu.nahouse.R.drawable.ic_launcher_foreground,
            title = "Manage",
            description = "Keep track of your bookings"
        )
    )

    val pagerState = rememberPagerState(initialPage = 0, pageCount = { items.size })
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        HorizontalPager(state = pagerState, modifier = Modifier.weight(1f)) { page ->
            val item = items[page]
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(painterResource(id = item.imageRes), contentDescription = null, modifier = Modifier.size(200.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = item.title)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = item.description)
            }
        }
        HorizontalPagerIndicator(pagerState = pagerState)
        Button(
            onClick = {
                if (pagerState.currentPage < items.lastIndex) {
                    scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                } else {
                    viewModel.completeOnboarding()
                    onFinish()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            val text = if (pagerState.currentPage == items.lastIndex) {
                stringResource(id = com.ungozu.nahouse.R.string.get_started)
            } else {
                stringResource(id = com.ungozu.nahouse.R.string.next)
            }
            Text(text)
        }
    }
}
