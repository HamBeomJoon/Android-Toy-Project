package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TopicSubmissions(
    @SerialName("architecture-interior")
    val architectureInterior: ArchitectureInterior,
)
