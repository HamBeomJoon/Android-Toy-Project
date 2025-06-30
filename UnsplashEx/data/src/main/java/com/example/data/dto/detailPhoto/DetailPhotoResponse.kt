package com.example.data.dto.detailPhoto

import com.example.data.dto.randomPhoto.AlternativeSlugs
import com.example.data.dto.randomPhoto.CurrentUserCollectionsResponseItem
import com.example.domain.DetailPhoto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DetailPhotoResponse(
    @SerialName("alternative_slugs")
    val alternativeSlugs: AlternativeSlugs,
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
    @SerialName("downloads")
    val downloads: Int,
    @SerialName("exif")
    val exif: Exif,
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
    @SerialName("location")
    val location: Location,
    @SerialName("public_domain")
    val publicDomain: Boolean,
    @SerialName("slug")
    val slug: String,
    @SerialName("tags")
    val tags: List<Tag>,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("user")
    val user: User,
    @SerialName("width")
    val width: Int,
)

fun DetailPhotoResponse.toDomain(): DetailPhoto =
    DetailPhoto(
        id = this.id,
        thumb = this.urls.thumb,
        title = this.slug,
        description = this.description,
        tags = this.tags.map { it.title },
    )
