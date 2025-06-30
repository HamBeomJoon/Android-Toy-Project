package com.example.data.service

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

class PrettyTimberLogger : HttpLoggingInterceptor.Logger {
    private val json =
        Json {
            prettyPrint = true
            isLenient = true
            ignoreUnknownKeys = true
        }

    override fun log(message: String) {
        val formatted =
            try {
                if (message.startsWith("{") || message.startsWith("[")) {
                    val element = json.decodeFromString<JsonElement>(message)
                    json.encodeToString(JsonElement.serializer(), element)
                } else {
                    message
                }
            } catch (e: Exception) {
                message
            }
        Timber.tag("HTTP").d(formatted)
    }
}
