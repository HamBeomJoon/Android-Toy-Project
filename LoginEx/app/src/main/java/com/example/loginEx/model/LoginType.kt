package com.example.loginEx.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class LoginType : Parcelable {
    KAKAO,
    NAVER,
    GOOGLE,
}
