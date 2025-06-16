package com.example.app.data.repository

import com.example.app.data.datasource.UserDataSource
import com.example.app.data.dto.toDomain
import com.example.app.domain.model.UserDetailInfo
import com.example.app.domain.model.UserInfo
import com.example.app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun getUsers(): Result<List<UserInfo>> =
        handleResult {
            val response = userDataSource.fetchUsers().getOrThrow()
            response.map { it.toDomain() }
        }

    override suspend fun getUser(name: String): Result<UserDetailInfo> =
        handleResult {
            val response = userDataSource.getUserByUsername(name).getOrThrow()
            response.toDomain()
        }
}
