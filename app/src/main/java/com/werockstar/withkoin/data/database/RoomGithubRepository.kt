package com.werockstar.withkoin.data.database

import com.werockstar.withkoin.data.remote.response.UserResponse
import com.werockstar.withkoin.data.repository.GithubUserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomGithubRepository(private val dao: UserDao) : GithubUserRepository {

    override suspend fun getUserByName(username: String): UserResponse {
        return withContext(Dispatchers.IO) {
            dao.getUserByName(username).let { UserResponse(it.id, it.login) }
        }
    }

    override suspend fun getUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) {
            dao.getUsers().map {
                UserResponse(it.id, it.login)
            }
        }
    }

}