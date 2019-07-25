package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel(private val useCase: GetUsersUseCase) : ViewModel() {

    private val liveData = MutableLiveData<List<UserResponse>>()

    fun getUserAll() {
        viewModelScope.launch {
            val userAsync = async { useCase.getGithubUsers() }
            try {
                liveData.value = userAsync.await()
            } catch (e: Exception) {
                //TODO: Handle exception
            }
        }
    }

    fun usersObserve(): LiveData<List<UserResponse>> = liveData
}