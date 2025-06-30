package com.example.data.dto.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Urls(
    @SerialName("full")
    val full: String,
    @SerialName("raw")
    val raw: String,
    @SerialName("regular")
    val regular: String,
    @SerialName("small")
    val small: String,
    @SerialName("thumb")
    val thumb: String,
)
