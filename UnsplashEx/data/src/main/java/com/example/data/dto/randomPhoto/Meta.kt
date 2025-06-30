package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Meta(
    @SerialName("index")
    val index: Boolean,
)
