package com.example.app.domain.model

data class UserDetailInfo(
    val profile: String,
    val userId: String,
    val followers: Int,
    val location: String? = null,
    val profileUrl: String,
    val repoUrl: String,
)
