package com.example.domain

data class PhotoDetail(
    val id: String,
    val thumb: String,
    val description: String,
    var isBookmark: Boolean,
)
