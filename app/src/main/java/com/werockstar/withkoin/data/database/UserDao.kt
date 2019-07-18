package com.werockstar.withkoin.data.database

import androidx.room.Query

interface UserDao {
    @Query("SELECT *FROM user")
    suspend fun getUsers(): List<UserEntity>

    @Query("SELECT *FROM user WHERE login = :username")
    suspend fun getUserByName(username: String): UserEntity
}