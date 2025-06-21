package com.example.app.di

import com.example.app.data.repository.UserRepositoryImpl
import com.example.app.domain.repository.UserRepository

object RepositoryModule {
    val userRepository: UserRepository by lazy {
        UserRepositoryImpl(DatasourceModule.userRemoteDataSource)
    }
}
