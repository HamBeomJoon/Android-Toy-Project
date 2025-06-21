package com.example.app.data.datasource.remote

import com.example.app.data.dto.RepositoryResponse
import com.example.app.data.dto.UserResponse
import com.example.app.data.dto.UsersResponse

interface UserRemoteDataSource {
    suspend fun getRandomUsers(afterUserId: Int): Result<List<UsersResponse>>

    suspend fun getUserByName(name: String): Result<UserResponse>

    suspend fun getUserRepository(url: String): Result<List<RepositoryResponse>>
}
