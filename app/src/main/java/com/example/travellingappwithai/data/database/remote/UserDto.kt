package com.example.travellingappwithai.data.database.remote

import androidx.room.PrimaryKey

data class UserDto(
    @PrimaryKey val userId: Int,
    val username: String,
    val email: String,
    val budget: Double?,
    val preferences: String?,
    val password: String
)