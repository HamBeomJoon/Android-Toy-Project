package com.example.data.dto.randomPhoto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AlternativeSlugs(
    @SerialName("de")
    val de: String,
    @SerialName("en")
    val en: String,
    @SerialName("es")
    val es: String,
    @SerialName("fr")
    val fr: String,
    @SerialName("it")
    val `it`: String,
    @SerialName("ja")
    val ja: String,
    @SerialName("ko")
    val ko: String,
    @SerialName("pt")
    val pt: String,
)
