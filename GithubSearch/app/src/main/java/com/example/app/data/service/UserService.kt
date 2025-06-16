package com.example.app.data.service

import com.example.app.data.dto.UserResponse
import com.example.app.data.dto.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface UserService {
    @GET("users")
    suspend fun requestUsers(): Response<List<UsersResponse>>

    @GET("users/{username}")
    suspend fun requestUserByName(
        @Path("username") username: String,
    ): Response<UserResponse>
}
