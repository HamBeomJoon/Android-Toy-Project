package com.example.githubSearch.data.repository

import com.example.githubSearch.BuildConfig

inline fun <T> handleResult(action: () -> T): Result<T> =
    runCatching(action).onFailure { throwable ->
        if (BuildConfig.DEBUG) throwable.printStackTrace()
    }
