package com.example.githubSearch.data.service

import okhttp3.OkHttpClient

object OkHttpClientProvider {
    fun provideClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(LoggingInterceptorProvider.provide())
            .addInterceptor(AuthorizationInterceptor())
            .build()
}
