package com.example.app.di

import com.example.app.data.datasource.remote.UserRemoteDataSource
import com.example.app.data.datasource.remote.UserRemoteDataSourceImpl

object DatasourceModule {
    val userRemoteDataSource: UserRemoteDataSource by lazy {
        UserRemoteDataSourceImpl(NetworkModule.userService)
    }
}
