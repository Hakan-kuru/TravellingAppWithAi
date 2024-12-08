package com.example.travellingappwithai.data.database.apiService

import com.example.travellingappwithai.data.database.remote.UserDto
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApiService {
    @GET("users")
    suspend fun getAllUsers(): List<UserDto>

    @GET("users/{id}")
    suspend fun getUserById(@Path("id") id: Int): UserDto

    @GET("users/{username}")
    suspend fun getUserByUsername(@Path("username") username: String): UserDto

    @GET("users/{email}")
    suspend fun getUserByEmail(@Path("email") email: String): UserDto

    @POST("users")
    suspend fun createUser(@Body user: UserDto): UserDto

    @PUT("users/{id}")
    suspend fun updateUser(@Path("id") id: Int, @Body user: UserDto): UserDto

    @DELETE("users/{id}")
    suspend fun deleteUser(@Path("id") id: Int)

}
