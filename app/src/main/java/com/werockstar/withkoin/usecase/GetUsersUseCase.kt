package com.werockstar.withkoin.usecase

import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.data.repository.GithubUserRepository

class GetUsersUseCase(private val repository: GithubUserRepository) {

    fun getGithubUsers(): List<UserResponse> {
        return repository.getUsers()
    }
}