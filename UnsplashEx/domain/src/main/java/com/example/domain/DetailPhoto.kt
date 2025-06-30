package com.example.domain

data class DetailPhoto(
    val id: String,
    val thumb: String,
    val title: String,
    val description: String,
    val tags: List<String>,
)
