package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrentUserCollectionsResponseItem(
    @SerialName("cover_photo")
    val coverPhoto: String? = null,
    @SerialName("id")
    val id: Int,
    @SerialName("last_collected_at")
    val lastCollectedAt: String,
    @SerialName("published_at")
    val publishedAt: String,
    @SerialName("title")
    val title: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("user")
    val user: String? = null,
)
