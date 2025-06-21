package com.example.app.domain.model

import java.time.LocalDateTime

data class RecentSearch(
    val keyword: String,
    val searchedAt: LocalDateTime,
)
