package com.example.githubSearch.data.datasource.remote

import com.example.githubSearch.data.dto.RepositoryResponse
import com.example.githubSearch.data.dto.UserResponse
import com.example.githubSearch.data.dto.UsersResponse

interface UserRemoteDataSource {
    suspend fun getRandomUsers(afterUserId: Int): Result<List<UsersResponse>>

    suspend fun getUserByName(name: String): Result<UserResponse>

    suspend fun getUserRepository(url: String): Result<List<RepositoryResponse>>
}
