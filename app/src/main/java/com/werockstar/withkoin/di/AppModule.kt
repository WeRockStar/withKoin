package com.werockstar.withkoin.di

import com.google.gson.Gson
import com.werockstar.withkoin.usecase.GetUsersUseCase
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    single { Gson() }
    factory { GetUsersUseCase(get(named("database")), get(named("remote"))) }
}