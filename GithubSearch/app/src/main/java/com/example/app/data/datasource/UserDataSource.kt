package com.example.app.data.datasource

import com.example.app.data.dto.RepositoryResponse
import com.example.app.data.dto.UserResponse
import com.example.app.data.dto.UsersResponse

interface UserDataSource {
    suspend fun fetchUsers(): Result<List<UsersResponse>>

    suspend fun getUserByUsername(name: String): Result<UserResponse>

    suspend fun fetchUserRepository(url: String): Result<List<RepositoryResponse>>
}
