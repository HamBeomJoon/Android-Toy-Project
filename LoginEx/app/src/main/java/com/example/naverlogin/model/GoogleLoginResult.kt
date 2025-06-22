package com.example.naverlogin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GoogleLoginResult(
    val idToken: String,
    val id: String,
    val displayName: String?,
) : Parcelable
