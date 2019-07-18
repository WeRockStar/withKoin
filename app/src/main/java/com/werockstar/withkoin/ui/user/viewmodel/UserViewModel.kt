package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel(private val useCase: GetUsersUseCase) : ViewModel() {

    fun getUserAll() {
        viewModelScope.launch {
            val userAsync = async {
                useCase.getGithubUsers()
            }
            userAsync.await()
        }
    }
}