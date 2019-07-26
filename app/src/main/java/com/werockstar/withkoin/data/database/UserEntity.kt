package com.werockstar.withkoin.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "login") val user: String,
    @ColumnInfo(name = "avatarUrl") val url: String,
    @ColumnInfo(name = "bio") val bio: String
)