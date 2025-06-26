package com.example.githubSearch.di

import com.example.githubSearch.data.repository.RecentKeywordRepositoryImpl
import com.example.githubSearch.data.repository.UserRepositoryImpl
import com.example.githubSearch.domain.repository.RecentKeywordRepository
import com.example.githubSearch.domain.repository.UserRepository

object RepositoryModule {
    val userRepository: UserRepository by lazy {
        UserRepositoryImpl(DatasourceModule.userRemoteDataSource)
    }

    val recentKeywordRepository: RecentKeywordRepository by lazy {
        RecentKeywordRepositoryImpl(DatasourceModule.recentKeywordLocalDataSource)
    }
}
