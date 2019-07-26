package com.werockstar.withkoin.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey val id: Int, @ColumnInfo(name = "login") val user: String,
    @ColumnInfo(name = "url") val url: String
)