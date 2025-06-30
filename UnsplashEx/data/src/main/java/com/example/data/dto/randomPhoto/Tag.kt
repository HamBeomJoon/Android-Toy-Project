package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Tag(
    @SerialName("title")
    val title: String,
    @SerialName("type")
    val type: String,
)
