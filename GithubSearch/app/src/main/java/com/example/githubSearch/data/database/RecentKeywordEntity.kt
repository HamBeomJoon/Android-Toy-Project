package com.example.githubSearch.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.githubSearch.domain.model.RecentSearch
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

@Entity(tableName = "recent_keywords")
data class RecentKeywordEntity(
    @PrimaryKey
    @ColumnInfo(name = "keyword")
    val keyword: String,
    @ColumnInfo(name = "searched_at")
    val searchedAt: Long = System.currentTimeMillis(),
)

fun RecentKeywordEntity.toDomain(): RecentSearch {
    val isoString =
        Instant
            .ofEpochMilli(searchedAt)
            .atZone(ZoneId.systemDefault())
            .withZoneSameInstant(ZoneOffset.UTC)
            .toInstant()
            .toString()

    return RecentSearch(keyword = keyword, searchedAt = isoString)
}

fun String.toEntity(): RecentKeywordEntity =
    RecentKeywordEntity(
        keyword = this,
        searchedAt = System.currentTimeMillis(),
    )
