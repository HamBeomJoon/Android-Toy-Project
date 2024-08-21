package com.example.presentation.di

import com.example.data.api.PhotoService
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

object ServiceModule {

    @Provides
    @Singleton
    fun provideDiaryService(retrofit: Retrofit): PhotoService =
        retrofit.create(PhotoService::class.java)
}