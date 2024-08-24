package com.example.core.data.di

import com.example.core.data.api.UnsplashService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Provides
    @Singleton
    fun providesUnsplashService(retrofit: Retrofit): UnsplashService =
        retrofit.create(UnsplashService::class.java)
}