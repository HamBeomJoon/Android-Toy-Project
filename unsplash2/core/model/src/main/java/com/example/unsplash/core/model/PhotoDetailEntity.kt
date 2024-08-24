package com.example.app.domain.model

data class PhotoDetailEntity(
    val id: String,
    val thumb: String,
    val description: String,
    var isBookmark: Boolean,
    val tags: List<String>,
    val country: String,
    val city: String,
    val likes: Int,
    val downloads: Int,
)