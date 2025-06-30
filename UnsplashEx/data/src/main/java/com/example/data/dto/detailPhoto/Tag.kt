package com.example.data.dto.detailPhoto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("title")
    val title: String
)