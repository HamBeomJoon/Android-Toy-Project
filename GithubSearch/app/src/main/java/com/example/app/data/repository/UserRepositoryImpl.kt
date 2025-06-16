package com.example.app.data.repository

import com.example.app.data.datasource.UserDataSource
import com.example.app.domain.model.UserInfo
import com.example.app.domain.repository.UserRepository

class UserRepositoryImpl(
    private val userDataSource: UserDataSource,
) : UserRepository {
    override suspend fun getUsers(): List<UserInfo> {
        TODO("Not yet implemented")
    }

    override suspend fun getUser(name: String): UserInfo {
        TODO("Not yet implemented")
    }
}
