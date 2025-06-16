package com.example.app.data.service

import okhttp3.OkHttpClient

object OkHttpClientProvider {
    //    private val id = UserPreference.getUserInfo("id")
//    private val password = UserPreference.getUserInfo("password")
//    private val credentials = "$id:$password"
//    private val basicAuth =
//        "Basic " + Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
//
    fun provideClient(): OkHttpClient =
        OkHttpClient
            .Builder()
            .addInterceptor(LoggingInterceptorProvider.provide())
//            .addInterceptor(AuthorizationInterceptor(basicAuth))
            .build()
}
