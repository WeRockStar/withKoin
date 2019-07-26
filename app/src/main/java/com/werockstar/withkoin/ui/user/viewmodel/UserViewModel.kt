package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.core.SingleLiveEvent
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserViewModel(private val useCase: GetUsersUseCase) : BaseViewModel() {

    private val liveData = SingleLiveEvent<List<UserResponse>>()

    fun getUserAll() {
        viewModelScope.launch(exceptionHandler) {
            val userAsync = async { useCase.getGithubUsers() }
            val users = userAsync.await()
            liveData.value = users
        }
    }

    fun usersObserve(): LiveData<List<UserResponse>> = liveData
}