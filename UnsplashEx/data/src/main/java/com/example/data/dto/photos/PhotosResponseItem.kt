package com.example.data.dto.photos

import com.example.data.dto.randomPhoto.CurrentUserCollectionsResponseItem
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PhotosResponseItem(
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("color")
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("current_user_collections")
    val currentUserCollections: List<CurrentUserCollectionsResponseItem?>,
    @SerialName("description")
    val description: String,
    @SerialName("height")
    val height: Int,
    @SerialName("id")
    val id: String,
    @SerialName("liked_by_user")
    val likedByUser: Boolean,
    @SerialName("likes")
    val likes: Int,
    @SerialName("links")
    val links: Links,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("user")
    val user: User,
    @SerialName("width")
    val width: Int,
)
