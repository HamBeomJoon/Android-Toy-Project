package com.example.app.di

import com.example.app.data.repository.RecentKeywordRepositoryImpl
import com.example.app.data.repository.UserRepositoryImpl
import com.example.app.domain.repository.RecentKeywordRepository
import com.example.app.domain.repository.UserRepository

object RepositoryModule {
    val userRepository: UserRepository by lazy {
        UserRepositoryImpl(DatasourceModule.userRemoteDataSource)
    }

    val recentKeywordRepository: RecentKeywordRepository by lazy {
        RecentKeywordRepositoryImpl(DatasourceModule.recentKeywordLocalDataSource)
    }
}
