package com.example.app.data.repository

import com.example.app.data.datasource.UserDataSource
import com.example.app.data.dto.toDomain
import com.example.app.domain.model.RepositoryInfo
import com.example.app.domain.model.UserDetailInfo
import com.example.app.domain.model.UserInfo
import com.example.app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun fetchRandomUsers(): Result<List<UserInfo>> =
        handleResult {
            val randomId = (1..100_000_000).random()
            val response = userDataSource.fetchUsers(afterUserId = randomId).getOrThrow()
            response.map { it.toDomain() }
        }

    override suspend fun getUser(name: String): Result<UserDetailInfo> =
        handleResult {
            val response = userDataSource.getUserByUsername(name).getOrThrow()
            response.toDomain()
        }

    override suspend fun fetchUserRepository(url: String): Result<List<RepositoryInfo>> =
        handleResult {
            val response = userDataSource.fetchUserRepository(url).getOrThrow()
            response.map { it.toDomain() }
        }
}
