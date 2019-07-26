package com.werockstar.withkoin.ui.user.viewmodel

import android.util.Log
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
                val users = userAsync.await()
                liveData.value = users
            } catch (e: Exception) {
                Log.e("ErrorJa", e.message ?: "")
            }
        }
    }

    fun usersObserve(): LiveData<List<UserResponse>> = liveData
}