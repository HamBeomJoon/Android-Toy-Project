package com.example.data.dto.photos

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Links(
    @SerialName("download")
    val download: String,
    @SerialName("download_location")
    val downloadLocation: String,
    @SerialName("html")
    val html: String,
    @SerialName("self")
    val self: String,
)
