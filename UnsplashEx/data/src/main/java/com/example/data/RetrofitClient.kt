package com.example.data

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object RetrofitClient {
    private const val BASE_URL = "https://api.unsplash.com"
    private val json =
        Json {
            ignoreUnknownKeys = true
            prettyPrint = false
            isLenient = true
        }

    private val loggingInterceptor =
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor(PrettyTimberLogger()).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        } else {
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.NONE
            }
        }

    private val client =
        OkHttpClient
            .Builder()
            .addInterceptor(loggingInterceptor)
            .build()

    private val contentType = "application/json".toMediaType()

    private val retrofit =
        Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .client(client)
            .build()

    fun getInstance(): Retrofit = retrofit
}
