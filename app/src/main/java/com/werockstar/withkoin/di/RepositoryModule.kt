package com.werockstar.withkoin.di

import com.werockstar.withkoin.data.database.RoomGithubRepository
import com.werockstar.withkoin.data.remote.RemoteGithubRepository
import com.werockstar.withkoin.data.repository.GithubUserRepository
import org.koin.dsl.module

val repositoryModule = module {
    single<GithubUserRepository> { RoomGithubRepository(get()) }
    single<GithubUserRepository> { RemoteGithubRepository(get()) }
}