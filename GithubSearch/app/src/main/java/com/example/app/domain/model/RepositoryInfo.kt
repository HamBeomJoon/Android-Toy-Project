package com.example.app.domain.model

data class RepositoryInfo(
    val id: Int,
    val name: String,
    val description: String? = null,
    val url: String,
    val visibility: String,
    val language: String? = null,
    val watchers: Int,
    val forks: Int,
    val stars: Int,
    val createdAt: String,
    val updatedAt: String,
)
