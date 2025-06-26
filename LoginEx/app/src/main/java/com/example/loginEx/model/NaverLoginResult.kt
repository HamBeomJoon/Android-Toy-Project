package com.example.loginEx.model

import com.navercorp.nid.oauth.NidOAuthLoginState
import kotlinx.parcelize.Parcelize

@Parcelize
data class NaverLoginResult(
    val accessToken: String?,
    val refreshToken: String?,
    val expires: Long,
    val tokenType: String?,
    val state: NidOAuthLoginState,
) : LoginResult(LoginType.NAVER)
