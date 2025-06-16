package com.example.app.domain.repository

import com.example.app.domain.model.UserDetailInfo
import com.example.app.domain.model.UserInfo

interface UserRepository {
    suspend fun getUsers(): Result<List<UserInfo>>

    suspend fun getUser(name: String): Result<UserDetailInfo>
}
