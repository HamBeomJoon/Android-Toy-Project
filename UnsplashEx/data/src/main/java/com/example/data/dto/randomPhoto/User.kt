package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class User(
    @SerialName("accepted_tos")
    val acceptedTos: Boolean,
    @SerialName("bio")
    val bio: String,
    @SerialName("first_name")
    val firstName: String,
    @SerialName("for_hire")
    val forHire: Boolean,
    @SerialName("id")
    val id: String,
    @SerialName("instagram_username")
    val instagramUsername: String,
    @SerialName("last_name")
    val lastName: String,
    @SerialName("links")
    val links: LinksX,
    @SerialName("location")
    val location: String,
    @SerialName("name")
    val name: String,
    @SerialName("portfolio_url")
    val portfolioUrl: String? = null,
    @SerialName("profile_image")
    val profileImage: ProfileImage,
    @SerialName("social")
    val social: Social,
    @SerialName("total_collections")
    val totalCollections: Int,
    @SerialName("total_illustrations")
    val totalIllustrations: Int,
    @SerialName("total_likes")
    val totalLikes: Int,
    @SerialName("total_photos")
    val totalPhotos: Int,
    @SerialName("total_promoted_illustrations")
    val totalPromotedIllustrations: Int,
    @SerialName("total_promoted_photos")
    val totalPromotedPhotos: Int,
    @SerialName("twitter_username")
    val twitterUsername: String? = null,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("username")
    val username: String,
)
