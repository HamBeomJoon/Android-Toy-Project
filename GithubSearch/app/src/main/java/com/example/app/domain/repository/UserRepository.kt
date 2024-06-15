package com.example.app.domain.repository

import com.example.app.domain.model.UserEntity

interface UserRepository {
    suspend fun searchUsers(username: String): Int
}