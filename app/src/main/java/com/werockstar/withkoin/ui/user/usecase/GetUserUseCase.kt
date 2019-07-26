package com.werockstar.withkoin.ui.user.usecase

import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.data.repository.GithubUserRepository

class GetUserUseCase(private val remoteRepository: GithubUserRepository) {

    suspend fun getGithubUser(userLogin: String): UserResponse {
        return remoteRepository.getUserByName(userLogin)
    }
}