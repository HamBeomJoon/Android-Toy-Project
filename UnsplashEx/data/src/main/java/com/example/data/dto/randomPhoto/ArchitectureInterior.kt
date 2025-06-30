package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArchitectureInterior(
    @SerialName("approved_on")
    val approvedOn: String,
    @SerialName("status")
    val status: String,
)
