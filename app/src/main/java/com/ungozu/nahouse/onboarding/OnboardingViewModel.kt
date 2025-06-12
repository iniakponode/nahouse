package com.ungozu.nahouse.onboarding

import androidx.lifecycle.ViewModel
import com.ungozu.core.PreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(
    private val prefs: PreferenceManager
) : ViewModel() {
    fun completeOnboarding() {
        prefs.setOnboardingCompleted(true)
    }
    fun isCompleted(): Boolean = prefs.isOnboardingCompleted()
}
