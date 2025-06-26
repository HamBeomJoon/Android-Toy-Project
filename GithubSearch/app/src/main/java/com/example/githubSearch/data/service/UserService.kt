package com.example.githubSearch.data.service

import com.example.githubSearch.data.dto.RepositoryResponse
import com.example.githubSearch.data.dto.UserResponse
import com.example.githubSearch.data.dto.UsersResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url

interface UserService {
    @GET("users")
    suspend fun requestUsers(
        @Query("since") afterUserId: Int = 0,
        @Query("per_page") pageSize: Int = 20,
    ): Response<List<UsersResponse>>

    @GET("users/{username}")
    suspend fun requestUserByName(
        @Path("username") username: String,
    ): Response<UserResponse>

    @GET
    suspend fun requestRepository(
        @Url url: String,
    ): Response<List<RepositoryResponse>>
}
