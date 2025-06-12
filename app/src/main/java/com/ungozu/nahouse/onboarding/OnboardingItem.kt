package com.ungozu.nahouse.onboarding

import androidx.annotation.DrawableRes

data class OnboardingItem(
    @DrawableRes val imageRes: Int,
    val title: String,
    val description: String
)
