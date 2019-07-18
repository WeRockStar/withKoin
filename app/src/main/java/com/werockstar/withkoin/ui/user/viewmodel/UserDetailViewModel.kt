package com.werockstar.withkoin.ui.user.viewmodel

import androidx.lifecycle.ViewModel
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase

class UserDetailViewModel(private val useCase: GetUsersUseCase) : ViewModel()