package com.example.app.data.datasource.remote

import com.example.app.data.datasource.handleApiCall
import com.example.app.data.dto.RepositoryResponse
import com.example.app.data.dto.UserResponse
import com.example.app.data.dto.UsersResponse
import com.example.app.data.service.UserService

class UserRemoteDataSourceImpl(
    private val userService: UserService,
) : UserRemoteDataSource {
    override suspend fun getRandomUsers(afterUserId: Int): Result<List<UsersResponse>> =
        handleApiCall(
            errorMessage = "유저들 정보 조회 실패",
            apiCall = { userService.requestUsers(afterUserId = afterUserId) },
            transform = { response ->
                response.body() ?: throw IllegalStateException("응답 바디가 null입니다.")
            },
        )

    override suspend fun getUserByName(name: String): Result<UserResponse> =
        handleApiCall(
            errorMessage = "유저 정보 조회 실패",
            apiCall = { userService.requestUserByName(name) },
            transform = { response ->
                response.body() ?: throw IllegalStateException("응답 바디가 null입니다.")
            },
        )

    override suspend fun getUserRepository(url: String): Result<List<RepositoryResponse>> =
        handleApiCall(
            errorMessage = "유저 레포지토리 조회 실패",
            apiCall = { userService.requestRepository(url) },
            transform = { response ->
                response.body() ?: throw IllegalStateException("응답 바디가 null입니다.")
            },
        )
}
