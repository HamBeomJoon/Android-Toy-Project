package com.example.naverlogin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
enum class LoginType : Parcelable {
    NAVER,
    GOOGLE,
}
