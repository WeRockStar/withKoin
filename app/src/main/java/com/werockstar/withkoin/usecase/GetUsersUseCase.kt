package com.werockstar.withkoin.usecase

import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.data.repository.GithubUserRepository

class GetUsersUseCase(
    private val localRepository: GithubUserRepository,
    private val remoteRepository: GithubUserRepository) {

    suspend fun getGithubUsers(): List<UserResponse> {
        return remoteRepository.getUsers()
    }

    suspend fun getGithubUsersCache(): List<UserResponse> {
        return localRepository.getUsers()
    }
}