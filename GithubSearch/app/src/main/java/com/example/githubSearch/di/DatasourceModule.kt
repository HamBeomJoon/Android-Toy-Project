package com.example.githubSearch.di

import com.example.githubSearch.data.datasource.local.RecentKeywordLocalDataSource
import com.example.githubSearch.data.datasource.local.RecentKeywordLocalDataSourceImpl
import com.example.githubSearch.data.datasource.remote.UserRemoteDataSource
import com.example.githubSearch.data.datasource.remote.UserRemoteDataSourceImpl

object DatasourceModule {
    val recentKeywordLocalDataSource: RecentKeywordLocalDataSource by lazy {
        val dao = DatabaseModule.recentKeywordDao
        RecentKeywordLocalDataSourceImpl(dao)
    }

    val userRemoteDataSource: UserRemoteDataSource by lazy {
        UserRemoteDataSourceImpl(NetworkModule.userService)
    }
}
