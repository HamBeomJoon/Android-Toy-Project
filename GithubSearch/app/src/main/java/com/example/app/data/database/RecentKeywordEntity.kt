package com.example.app.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.app.domain.model.RecentSearch
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset

@Entity(tableName = "recent_keywords")
data class RecentKeywordEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "keyword_id")
    val id: Long = 0L,
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
