package com.example.data.dto.detailPhoto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Location(
    @SerialName("city")
    val city: String,
    @SerialName("country")
    val country: String,
    @SerialName("position")
    val position: Position
)