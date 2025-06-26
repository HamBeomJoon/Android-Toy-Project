package com.example.githubSearch.domain.repository

import com.example.githubSearch.domain.model.RecentSearch

interface RecentKeywordRepository {
    suspend fun getAllKeywords(): Result<List<RecentSearch>>

    suspend fun addKeyword(keyword: String): Result<Unit>

    suspend fun deleteKeyword(keyword: String): Result<Unit>

    suspend fun clearKeywords(): Result<Unit>
}
