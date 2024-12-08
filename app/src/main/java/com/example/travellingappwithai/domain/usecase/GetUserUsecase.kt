package com.example.travellingappwithai.domain.usecase

import com.example.travellingappwithai.data.database.repositories.UserRepository
import com.example.travellingappwithai.domain.models.User

// execute neden kullanılmıyor ona bak
class GetUserUsecase( private val userRepository: UserRepository) {

    suspend fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    suspend fun updateUser(user: User) {
        userRepository.updateUser(user)
    }

    suspend fun createUser(user: User) {
        userRepository.createUser(user)
    }

    suspend fun getUserByEmail(email: String): User? {
        return userRepository.getUserByEmail(email)
    }

    suspend fun deleteUser(id: Int) {
        userRepository.deleteUser(id)
    }

    suspend fun getUserByUsername(username: String): User? {
        return userRepository.getUserByUsername(username)
    }

    suspend fun getAllUsers(): List<User> {
        return userRepository.getAllUsers()
    }
}
