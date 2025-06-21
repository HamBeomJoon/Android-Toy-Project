package com.example.app.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class LicenseResponse(
    @SerialName("key")
    val key: String,
    @SerialName("name")
    val name: String,
    @SerialName("node_id")
    val nodeId: String,
    @SerialName("spdx_id")
    val spdxId: String,
    @SerialName("url")
    val url: String? = null,
)
