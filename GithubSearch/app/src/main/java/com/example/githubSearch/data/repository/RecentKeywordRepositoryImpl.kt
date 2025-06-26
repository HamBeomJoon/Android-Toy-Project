package com.example.githubSearch.data.repository

import com.example.githubSearch.data.database.toDomain
import com.example.githubSearch.data.database.toEntity
import com.example.githubSearch.data.datasource.local.RecentKeywordLocalDataSource
import com.example.githubSearch.domain.model.RecentSearch
import com.example.githubSearch.domain.repository.RecentKeywordRepository

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
            val entity = keyword.toEntity()
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
