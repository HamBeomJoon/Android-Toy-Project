package com.example.githubSearch.data.repository

import com.example.githubSearch.data.datasource.remote.UserRemoteDataSource
import com.example.githubSearch.data.dto.toDomain
import com.example.githubSearch.domain.model.RepositoryInfo
import com.example.githubSearch.domain.model.UserDetailInfo
import com.example.githubSearch.domain.model.UserInfo
import com.example.githubSearch.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userRemoteDataSource: UserRemoteDataSource,
) : UserRepository {
    override suspend fun fetchRandomUsers(): Result<List<UserInfo>> =
        handleResult {
            val randomId = (1..10_000_000).random()
            val response = userRemoteDataSource.getRandomUsers(afterUserId = randomId).getOrThrow()
            response.map { it.toDomain() }
        }

    override suspend fun getUser(name: String): Result<UserDetailInfo> =
        handleResult {
            val response = userRemoteDataSource.getUserByName(name).getOrThrow()
            response.toDomain()
        }

    override suspend fun fetchUserRepository(url: String): Result<List<RepositoryInfo>> =
        handleResult {
            val response = userRemoteDataSource.getUserRepository(url).getOrThrow()
            response.map { it.toDomain() }
        }
}
