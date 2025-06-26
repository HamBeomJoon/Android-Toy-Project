package com.example.githubSearch.domain.repository

import com.example.githubSearch.domain.model.RepositoryInfo
import com.example.githubSearch.domain.model.UserDetailInfo
import com.example.githubSearch.domain.model.UserInfo

interface UserRepository {
    suspend fun fetchRandomUsers(): Result<List<UserInfo>>

    suspend fun getUser(name: String): Result<UserDetailInfo>

    suspend fun fetchUserRepository(url: String): Result<List<RepositoryInfo>>
}
