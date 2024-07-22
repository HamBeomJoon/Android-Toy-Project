package com.example.domain

data class PhotoEntity(
    val id: String,
    val thumb: String,
    val description: String,
    var isBookmark: Boolean,
)