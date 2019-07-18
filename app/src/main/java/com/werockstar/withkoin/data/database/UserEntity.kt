package com.werockstar.withkoin.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user")
data class UserEntity(@PrimaryKey val id: Int, val login: String)