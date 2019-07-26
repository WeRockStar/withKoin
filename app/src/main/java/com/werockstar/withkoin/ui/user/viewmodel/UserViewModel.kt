package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserViewModel(private val useCase: GetUsersUseCase) : ViewModel() {

    private val liveData = MutableLiveData<List<UserResponse>>()

    fun getUserAll() {
        viewModelScope.launch {
            val userAsync = async(Dispatchers.IO) { useCase.getGithubUsers() }
            try {
                val users = userAsync.await()
                liveData.value = users
            } catch (e: HttpException) {

            }
        }
    }

    fun usersObserve(): LiveData<List<UserResponse>> = liveData
}