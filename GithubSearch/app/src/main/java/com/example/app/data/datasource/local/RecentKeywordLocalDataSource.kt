package com.example.app.data.datasource.local

import com.example.app.data.database.RecentKeywordEntity

interface RecentKeywordLocalDataSource {
    suspend fun getAllKeywords(): List<RecentKeywordEntity>

    suspend fun saveKeyword(keyword: RecentKeywordEntity)

    suspend fun deleteKeyword(keyword: String)

    suspend fun clearKeywords()
}
