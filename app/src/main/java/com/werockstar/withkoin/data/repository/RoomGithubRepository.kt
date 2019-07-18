package com.werockstar.withkoin.data.repository

import androidx.room.RoomDatabase
import com.werockstar.withkoin.data.database.AppDatabase
import com.werockstar.withkoin.data.database.UserDao
import com.werockstar.withkoin.data.remote.response.UserResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class RoomGithubRepository(private val room: AppDatabase) : GithubUserRepository {

    override suspend fun getUserByName(username: String): UserResponse {
        return withContext(Dispatchers.IO) {
            room.userDao().getUserByName(username).let { UserResponse(it.id, it.user) }
        }
    }

    override suspend fun getUsers(): List<UserResponse> {
        return withContext(Dispatchers.IO) {
            room.userDao().getUsers().map {
                UserResponse(it.id, it.user)
            }
        }
    }

}