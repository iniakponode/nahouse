package com.ungozu.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject
@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _welcomeMessage = MutableStateFlow("Welcome to NaHouse")
    val welcomeMessage: StateFlow<String> = _welcomeMessage
}
