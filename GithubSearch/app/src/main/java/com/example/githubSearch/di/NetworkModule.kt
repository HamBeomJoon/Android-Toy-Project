package com.example.githubSearch.di

import com.example.githubSearch.BuildConfig
import com.example.githubSearch.data.service.OkHttpClientProvider
import com.example.githubSearch.data.service.UserService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.create

object NetworkModule {
    private const val BASE_URL = BuildConfig.BASE_URL

    private val retrofit: Retrofit by lazy {
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClientProvider.provideClient())
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    val userService: UserService by lazy { retrofit.create() }
}
