package com.example.data

import okhttp3.Interceptor
import okhttp3.Response

class HeaderInterceptor(
    private val version: String,
    private val token: String,
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val requestWithHeaders =
            original
                .newBuilder()
                .addHeader("Accept-Version", version)
                .addHeader("Authorization", "Client-ID $token")
                .build()

        return chain.proceed(requestWithHeaders)
    }
}
