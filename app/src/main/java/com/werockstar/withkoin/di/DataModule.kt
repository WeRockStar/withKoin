package com.werockstar.withkoin.di

import androidx.room.Room
import com.werockstar.withkoin.data.database.AppDatabase
import com.werockstar.withkoin.data.repository.RoomGithubRepository
import com.werockstar.withkoin.data.repository.RemoteGithubRepository
import com.werockstar.withkoin.data.repository.GithubUserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.core.qualifier.named
import org.koin.dsl.module

val dataModule = module {
    factory<GithubUserRepository>(named("database")) { RoomGithubRepository(get()) }
    factory<GithubUserRepository>(named("remote")) { RemoteGithubRepository(get()) }
    factory {
        Room.databaseBuilder(
            androidApplication(), AppDatabase::class.java, "koin-app"
        ).build()
    }
}