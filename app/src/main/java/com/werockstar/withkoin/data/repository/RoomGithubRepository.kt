package com.werockstar.withkoin.data.repository

import com.werockstar.withkoin.core.ThreadDispatcher
import com.werockstar.withkoin.data.database.AppDatabase
import com.werockstar.withkoin.data.remote.response.UserResponse
import kotlinx.coroutines.withContext

class RoomGithubRepository(private val room: AppDatabase, private val dispatcher: ThreadDispatcher) :
    GithubUserRepository {

    override suspend fun getUserByName(username: String): UserResponse {
        return withContext(dispatcher.io()) {
            room.userDao().getUserByName(username).let { UserResponse(it.id, it.user) }
        }
    }

    override suspend fun getUsers(): List<UserResponse> {
        return withContext(dispatcher.io()) {
            room.userDao().getUsers().map {
                UserResponse(it.id, it.user)
            }
        }
    }

}