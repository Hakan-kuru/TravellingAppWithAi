package com.example.travellingappwithai.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.travellingappwithai.domain.usecase.GetUserUsecase
import com.example.travellingappwithai.domain.models.User
import kotlinx.coroutines.launch

class UserViewModel(private val getUserUsecase: GetUserUsecase) : ViewModel(){
        fun loadUser(userId: Int,onResult: (User?) -> Unit){
            viewModelScope.launch {
                val users = getUserUsecase.getUserById(userId)
                onResult(users)
            }
        }

        fun insertUser(user: User, onComplete: () -> Unit) {
            viewModelScope.launch {
                getUserUsecase.createUser(user)
                onComplete()
            }
        }

        fun getUserByEmail(email: String, onResult: (User?) -> Unit) {
            viewModelScope.launch {
                val user = getUserUsecase.getUserByEmail(email)
                onResult(user)
            }
        }

        fun getUserByUsername(username: String, onResult: (User?) -> Unit) {
            viewModelScope.launch {
                val user = getUserUsecase.getUserByUsername(username)
                onResult(user)
            }
        }

        fun updateUser(user: User, onComplete: () -> Unit) {
            viewModelScope.launch {
                getUserUsecase.updateUser(user)
                onComplete()
            }
        }
        fun deleteUser(userId: Int,onComplete: () -> Unit){
            viewModelScope.launch {
                getUserUsecase.deleteUser(userId)
                onComplete()
                }
        }
        fun getAllUsers(onResult: (List<User>) -> Unit){
            viewModelScope.launch {
                val users = getUserUsecase.getAllUsers()
                onResult(users)
            }
        }
}