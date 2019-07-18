package com.werockstar.withkoin.data.repository

import com.werockstar.withkoin.core.ThreadDispatcher
import com.werockstar.withkoin.data.remote.GithubAPI
import com.werockstar.withkoin.data.remote.response.UserResponse
import kotlinx.coroutines.*

class RemoteGithubRepository(private val api: GithubAPI, private val dispatcher: ThreadDispatcher) :
    GithubUserRepository {

    override suspend fun getUserByName(username: String): UserResponse {
        return withContext(dispatcher.io()) { api.getUserByName(username) }
    }

    override suspend fun getUsers(): List<UserResponse> {
        return withContext(dispatcher.io()) { api.getUsers() }
    }

}