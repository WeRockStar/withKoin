package com.werockstar.withkoin.data.remote

import com.werockstar.withkoin.data.remote.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubAPI {
    @GET("users")
    suspend fun getUsers(): List<UserResponse>

    @GET("users/{username}")
    suspend fun getUserByName(@Path("username") username: String): UserResponse
}