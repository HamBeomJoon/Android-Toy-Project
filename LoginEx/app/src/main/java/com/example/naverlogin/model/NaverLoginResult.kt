package com.example.naverlogin.model

import android.os.Parcelable
import com.navercorp.nid.oauth.NidOAuthLoginState
import kotlinx.parcelize.Parcelize

@Parcelize
data class NaverLoginResult(
    val accessToken: String?,
    val refreshToken: String?,
    val expires: Long,
    val type: String?,
    val state: NidOAuthLoginState,
) : Parcelable
