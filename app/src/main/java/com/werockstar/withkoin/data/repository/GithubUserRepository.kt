package com.werockstar.withkoin.data.repository

import com.werockstar.withkoin.data.remote.response.UserResponse

interface GithubUserRepository {
    suspend fun getUserByName(username: String): UserResponse
    suspend fun getUsers(): List<UserResponse>
}