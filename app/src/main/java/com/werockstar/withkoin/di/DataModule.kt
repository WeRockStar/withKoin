package com.werockstar.withkoin.di

import androidx.room.Room
import com.werockstar.withkoin.data.database.AppDatabase
import com.werockstar.withkoin.data.repository.GithubUserRepository
import com.werockstar.withkoin.data.repository.RemoteGithubRepository
import com.werockstar.withkoin.data.repository.RoomGithubRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    single<GithubUserRepository>(named("database")) { RoomGithubRepository(get(), get()) }
    single<GithubUserRepository>(named("remote")) { RemoteGithubRepository(get(), get()) }
    single {
        Room.databaseBuilder(androidApplication(), AppDatabase::class.java, "koin-app").build()
    }
}