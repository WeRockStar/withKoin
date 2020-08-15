package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.ui.user.usecase.GetUserUseCase
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class UserDetailViewModel(private val useCase: GetUserUseCase) : BaseViewModel() {

    private val _user = MutableLiveData<UserResponse>()
	val user: LiveData<UserResponse> = _user

    fun getUser(userLogin: String) {
        viewModelScope.launch(exceptionHandler) {
            val async = async { useCase.getGithubUser(userLogin) }
            val user = async.await()
            _user.value = user
        }
    }
}
