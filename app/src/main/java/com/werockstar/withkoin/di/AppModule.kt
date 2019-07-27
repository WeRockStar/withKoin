package com.werockstar.withkoin.di

import com.google.gson.Gson
import com.werockstar.withkoin.core.CoroutinesDispatcher
import com.werockstar.withkoin.core.ThreadDispatcher
import com.werockstar.withkoin.ui.user.usecase.GetUserUseCase
import com.werockstar.withkoin.ui.user.usecase.GetUsersUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    factory { GetUsersUseCase(get(named("database")), get(named("remote"))) }
    factory { GetUserUseCase(get(named("remote"))) }
    single<ThreadDispatcher> { CoroutinesDispatcher() }
}