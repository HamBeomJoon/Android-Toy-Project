package com.example.githubSearch.data.datasource.local

import com.example.githubSearch.data.database.RecentKeywordDao
import com.example.githubSearch.data.database.RecentKeywordEntity

class RecentKeywordLocalDataSourceImpl(
    private val recentKeywordDao: RecentKeywordDao,
) : RecentKeywordLocalDataSource {
    override suspend fun getAllKeywords(): List<RecentKeywordEntity> = recentKeywordDao.getAllRecentKeywords()

    override suspend fun saveKeyword(keyword: RecentKeywordEntity) = recentKeywordDao.insertKeyword(keyword)

    override suspend fun deleteKeyword(keyword: String) = recentKeywordDao.deleteByKeyword(keyword)

    override suspend fun clearKeywords() = recentKeywordDao.deleteAllKeywords()
}
