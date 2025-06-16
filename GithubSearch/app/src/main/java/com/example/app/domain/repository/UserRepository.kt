package com.example.app.domain.repository

import com.example.app.domain.model.UserInfo

interface UserRepository {
    suspend fun getUsers(): List<UserInfo>

    suspend fun getUser(name: String): UserInfo
}
