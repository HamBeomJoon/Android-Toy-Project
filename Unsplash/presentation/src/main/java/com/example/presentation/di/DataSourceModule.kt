package com.example.presentation.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataSourceModule {
    @Provides
    @Singleton
    fun provideRemoteDataSource() = UserRemoteDataSourceImpl()
}