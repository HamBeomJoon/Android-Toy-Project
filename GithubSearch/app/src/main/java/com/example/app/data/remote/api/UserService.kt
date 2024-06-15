package com.example.app.data.remote.api

import com.example.app.data.model.ResponseUserDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


interface UserService {
    @GET("search/users")
    suspend fun searchUsers(
        @Query("q") username: String,
    ): Response<List<ResponseUserDTO>>
}