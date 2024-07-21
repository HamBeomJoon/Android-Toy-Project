package com.example.data.module

import com.example.data.api.PhotoService
import com.example.data.api.RetrofitClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class ApiModule {

    @Provides
    @Singleton
    fun provideApiInterface(): PhotoService {
        return RetrofitClient.getInstance().create(PhotoService::class.java)
    }
}