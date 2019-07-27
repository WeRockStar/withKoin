package com.werockstar.withkoin.di

import com.werockstar.withkoin.ui.user.viewmodel.UserDetailViewModel
import com.werockstar.withkoin.ui.user.viewmodel.UserViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { UserViewModel(get()) }
    viewModel { UserDetailViewModel(get()) }
}