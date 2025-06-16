package com.example.app.di

import com.example.app.data.datasource.UserDataSource
import com.example.app.data.datasource.UserDataSourceImpl

object DatasourceModule {
    val userDataSource: UserDataSource by lazy {
        UserDataSourceImpl(NetworkModule.userService)
    }
}
