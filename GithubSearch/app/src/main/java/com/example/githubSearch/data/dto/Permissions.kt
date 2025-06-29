package com.example.githubSearch.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Permissions(
    @SerialName("admin")
    val admin: Boolean,
    @SerialName("maintain")
    val maintain: Boolean,
    @SerialName("pull")
    val pull: Boolean,
    @SerialName("push")
    val push: Boolean,
    @SerialName("triage")
    val triage: Boolean,
)
