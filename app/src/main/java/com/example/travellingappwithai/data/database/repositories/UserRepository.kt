package com.example.travellingappwithai.data.database.repositories

import com.example.travellingappwithai.data.database.local.daos.UserDao
import com.example.travellingappwithai.data.database.local.entity.UserEntity
import com.example.travellingappwithai.data.network.UserRemoteDataSource
import com.example.travellingappwithai.utils.NetworkHelper
import com.example.travellingappwithai.domain.models.User

class UserRepository(
    private val userDao: UserDao,
    private val remoteDataSource: UserRemoteDataSource,
    private val networkHelper: NetworkHelper
) {

    suspend fun getAllUsers(): List<User> {
        return if (networkHelper.isNetworkConnected()) {
            val remoteUsers = remoteDataSource.fetchAllUsers()
            userDao.deleteAllUsers()
            remoteUsers.forEach { userDao.insertUser(it.toEntity()) }
            remoteUsers
        } else {
            userDao.getAllUsers().map { it.toDomainModel() }
        }
    }

    suspend fun getUserById(userId: Int): User? {
        return if (networkHelper.isNetworkConnected()) {
            val remoteUser = remoteDataSource.fetchUserById(userId)
            remoteUser?.let { userDao.insertUser(it.toEntity()) }
            remoteUser
        } else {
            userDao.getUserById(userId)?.toDomainModel()
        }
    }

    suspend fun getUserByEmail(email: String): User? {
        return userDao.getUserByEmail(email)?.toDomainModel()
    }

    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)?.toDomainModel()
    }

    suspend fun createUser(user: User) {
        if (networkHelper.isNetworkConnected()) {
            remoteDataSource.createUser(user)
        }else {
            userDao.insertUser(user.toEntity())
        }
    }

    suspend fun updateUser(user: User) {
        if (networkHelper.isNetworkConnected()) {
            remoteDataSource.updateUser(user)
        }
        userDao.insertUser(user.toEntity())
    }

    suspend fun deleteUser(userId: Int) {
        if (networkHelper.isNetworkConnected()) {
            remoteDataSource.deleteUser(userId)
        }else {
            userDao.deleteUserById(userId)
        }
    }
}

fun UserEntity.toDomainModel() = User(userId, username, email, budget, preferences, password)
fun User.toEntity() = UserEntity(userId, username, email, budget, preferences, password)