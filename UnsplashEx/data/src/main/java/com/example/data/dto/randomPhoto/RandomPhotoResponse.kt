package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RandomPhotoResponse(
    @SerialName("alt_description")
    val altDescription: String,
    @SerialName("alternative_slugs")
    val alternativeSlugs: AlternativeSlugs,
    @SerialName("asset_type")
    val assetType: String,
    @SerialName("blur_hash")
    val blurHash: String,
    @SerialName("breadcrumbs")
    val breadcrumbs: List<String>,
    @SerialName("color")
    val color: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("current_user_collections")
    val currentUserCollections: List<CurrentUserCollectionsResponseItem>,
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
    @SerialName("meta")
    val meta: Meta,
    @SerialName("promoted_at")
    val promotedAt: String? = null,
    @SerialName("public_domain")
    val publicDomain: Boolean,
    @SerialName("slug")
    val slug: String,
    @SerialName("sponsorship")
    val sponsorship: String? = null,
    @SerialName("tags")
    val tags: List<Tag>,
    @SerialName("topic_submissions")
    val topicSubmissions: TopicSubmissions,
    @SerialName("topics")
    val topics: List<Topic>,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("urls")
    val urls: Urls,
    @SerialName("user")
    val user: User,
    @SerialName("views")
    val views: Int,
    @SerialName("width")
    val width: Int,
)
