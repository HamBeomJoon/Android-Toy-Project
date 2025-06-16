package com.example.app.domain.repository

interface UserRepository {
    suspend fun searchUsers(username: String): Int
}
