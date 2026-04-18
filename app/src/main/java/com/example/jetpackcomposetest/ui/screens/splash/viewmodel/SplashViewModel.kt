package com.example.jetpackcomposetest.ui.screens.splash.viewmodel

import androidx.lifecycle.ViewModel
import com.example.jetpackcomposetest.utils.EncryptedUserCheckingManager
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(private val prefManager: EncryptedUserCheckingManager) : ViewModel(){

    fun isLoggedIn(): Boolean = prefManager.isLoggedIn()  // fast, fine on main

    // If you ever do heavier prefs work:
    suspend fun getUserData() = withContext(Dispatchers.IO) {
        prefManager.getUser()
    }
}