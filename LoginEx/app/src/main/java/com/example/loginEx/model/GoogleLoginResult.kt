package com.example.loginEx.model

import kotlinx.parcelize.Parcelize

@Parcelize
data class GoogleLoginResult(
    val idToken: String,
    val id: String,
    val displayName: String?,
) : LoginResult(LoginType.GOOGLE)
