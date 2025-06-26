package com.example.loginEx.model

import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
data class KakaoLoginResult(
    val accessToken: String,
    val accessTokenExpiresAt: Date,
    val refreshToken: String,
    val refreshTokenExpiresAt: Date,
    val idToken: String? = null,
    val scopes: List<String>? = null,
) : LoginResult(LoginType.KAKAO)
