package com.example.app.data.repository

import com.example.app.data.database.RecentKeywordEntity
import com.example.app.data.database.toDomain
import com.example.app.data.datasource.local.RecentKeywordLocalDataSource
import com.example.app.domain.model.RecentSearch
import com.example.app.domain.repository.RecentKeywordRepository

class RecentKeywordRepositoryImpl(
    private val recentKeywordLocalDataSource: RecentKeywordLocalDataSource,
) : RecentKeywordRepository {
    override suspend fun getAllKeywords(): Result<List<RecentSearch>> =
        handleResult {
            val result = recentKeywordLocalDataSource.getAllKeywords()
            result.map { it.toDomain() }
        }

    override suspend fun addKeyword(keyword: String): Result<Unit> =
        handleResult {
            val entity = RecentKeywordEntity(keyword = keyword)
            recentKeywordLocalDataSource.saveKeyword(entity)
        }

    override suspend fun deleteKeyword(keyword: String): Result<Unit> =
        handleResult {
            recentKeywordLocalDataSource.deleteKeyword(keyword)
        }

    override suspend fun clearKeywords(): Result<Unit> =
        handleResult {
            recentKeywordLocalDataSource.clearKeywords()
        }
}
