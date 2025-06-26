package com.example.githubSearch.data.datasource.local

import com.example.githubSearch.data.database.RecentKeywordEntity

interface RecentKeywordLocalDataSource {
    suspend fun getAllKeywords(): List<RecentKeywordEntity>

    suspend fun saveKeyword(keyword: RecentKeywordEntity)

    suspend fun deleteKeyword(keyword: String)

    suspend fun clearKeywords()
}
