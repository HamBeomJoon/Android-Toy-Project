package com.example.loginEx.model

import android.os.Parcelable

sealed class LoginResult(
    val type: LoginType,
) : Parcelable
