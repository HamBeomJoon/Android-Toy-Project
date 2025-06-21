package com.example.app.domain.repository

interface RecentKeywordRepository {
    suspend fun getAllKeywords(): Result<List<String>>

    suspend fun addKeyword(keyword: String): Result<Unit>

    suspend fun deleteKeyword(keyword: String): Result<Unit>

    suspend fun clearKeywords(): Result<Unit>
}
