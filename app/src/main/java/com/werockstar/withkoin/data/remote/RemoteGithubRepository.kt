package com.werockstar.withkoin.data.remote

import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.data.repository.GithubUserRepository
import kotlinx.coroutines.*

class RemoteGithubRepository(private val api: GithubAPI) : GithubUserRepository {

    override suspend fun getUserByName(username: String): UserResponse {
        return withContext(Dispatchers.IO) { api.getUserByName(username) }
    }

    override suspend fun getUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) { api.getUsers() }
    }

}