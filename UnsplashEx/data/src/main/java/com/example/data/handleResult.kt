package com.example.data

inline fun <T> handleResult(action: () -> T): Result<T> =
    runCatching(action).onFailure { throwable ->
        if (BuildConfig.DEBUG) throwable.printStackTrace()
    }
