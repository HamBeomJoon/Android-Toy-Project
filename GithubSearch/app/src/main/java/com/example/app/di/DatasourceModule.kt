package com.example.app.di

import com.example.app.data.datasource.local.RecentKeywordLocalDataSource
import com.example.app.data.datasource.local.RecentKeywordLocalDataSourceImpl
import com.example.app.data.datasource.remote.UserRemoteDataSource
import com.example.app.data.datasource.remote.UserRemoteDataSourceImpl

object DatasourceModule {
    val recentKeywordLocalDataSource: RecentKeywordLocalDataSource by lazy {
        RecentKeywordLocalDataSourceImpl(DatabaseModule.recentKeywordDao)
    }

    val userRemoteDataSource: UserRemoteDataSource by lazy {
        UserRemoteDataSourceImpl(NetworkModule.userService)
    }
}
