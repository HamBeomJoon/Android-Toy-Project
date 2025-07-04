package com.example.githubSearch.data.dto

import com.example.githubSearch.domain.model.UserDetailInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("bio")
    val bio: String? = null,
    @SerialName("blog")
    val blog: String? = null,
    @SerialName("company")
    val company: String? = null,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("email")
    val email: String? = null,
    @SerialName("events_url")
    val eventsUrl: String,
    @SerialName("followers")
    val followers: Int,
    @SerialName("followers_url")
    val followersUrl: String,
    @SerialName("following")
    val following: Int,
    @SerialName("following_url")
    val followingUrl: String,
    @SerialName("gists_url")
    val gistsUrl: String,
    @SerialName("gravatar_id")
    val gravatarId: String,
    @SerialName("hireable")
    val hireable: String? = null,
    @SerialName("html_url")
    val htmlUrl: String,
    @SerialName("id")
    val id: Int,
    @SerialName("location")
    val location: String? = null,
    @SerialName("login")
    val login: String,
    @SerialName("name")
    val name: String? = null,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("organizations_url")
    val organizationsUrl: String,
    @SerialName("public_gists")
    val publicGists: Int,
    @SerialName("public_repos")
    val publicRepos: Int,
    @SerialName("received_events_url")
    val receivedEventsUrl: String,
    @SerialName("repos_url")
    val reposUrl: String,
    @SerialName("site_admin")
    val siteAdmin: Boolean,
    @SerialName("starred_url")
    val starredUrl: String,
    @SerialName("subscriptions_url")
    val subscriptionsUrl: String,
    @SerialName("twitter_username")
    val twitterUsername: String? = null,
    @SerialName("type")
    val type: String,
    @SerialName("updated_at")
    val updatedAt: String,
    @SerialName("url")
    val url: String,
    @SerialName("user_view_type")
    val userViewType: String,
)

fun UserResponse.toDomain(): UserDetailInfo =
    UserDetailInfo(
        profile = this.avatarUrl,
        userId = this.login,
        followers = this.followers,
        location = this.location,
        profileUrl = this.htmlUrl,
        repoUrl = this.reposUrl,
    )
