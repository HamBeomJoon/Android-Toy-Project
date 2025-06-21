package com.example.app.domain.repository

import com.example.app.domain.model.RecentSearch

interface RecentKeywordRepository {
    suspend fun getAllKeywords(): Result<List<RecentSearch>>

    suspend fun addKeyword(keyword: String): Result<Unit>

    suspend fun deleteKeyword(keyword: String): Result<Unit>

    suspend fun clearKeywords(): Result<Unit>
}
