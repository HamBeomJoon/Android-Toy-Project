package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Exif(
    @SerialName("aperture")
    val aperture: String,
    @SerialName("exposure_time")
    val exposureTime: String,
    @SerialName("focal_length")
    val focalLength: String,
    @SerialName("iso")
    val iso: Int,
    @SerialName("make")
    val make: String,
    @SerialName("model")
    val model: String,
    @SerialName("name")
    val name: String,
)
