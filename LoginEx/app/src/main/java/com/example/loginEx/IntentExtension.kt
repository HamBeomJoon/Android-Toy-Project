package com.example.loginEx

import android.content.Intent
import android.os.Build
import android.os.Parcelable

inline fun <reified T : Parcelable> Intent.getParcelableExtraCompat(key: String): T =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        getParcelableExtra(key, T::class.java)
            ?: error(ERROR_NO_DATA.format(key))
    } else {
        @Suppress("DEPRECATION")
        getParcelableExtra(key)
            ?: error(ERROR_NO_DATA.format(key))
    }

const val ERROR_NO_DATA = "%s 데이터를 찾을 수 없습니다."
