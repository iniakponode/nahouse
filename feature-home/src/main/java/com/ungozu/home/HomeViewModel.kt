package com.ungozu.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.LiveData

class HomeViewModel : ViewModel() {
    private val _welcomeMessage = MutableLiveData("Welcome to NaHouse")
    val welcomeMessage: LiveData<String> = _welcomeMessage
}
