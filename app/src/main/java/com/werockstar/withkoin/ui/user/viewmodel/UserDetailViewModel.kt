package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.usecase.GetUserUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import retrofit2.HttpException

class UserDetailViewModel(private val useCase: GetUserUseCase) : ViewModel() {

    private val liveData = MutableLiveData<UserResponse>()

    fun getUser(userLogin: String) {
        viewModelScope.launch {
            val async = async { useCase.getGithubUser(userLogin) }

            try {
                val user = async.await()
                liveData.value = user
            } catch (e: HttpException) {

            }
        }
    }

    fun observe() = liveData
}