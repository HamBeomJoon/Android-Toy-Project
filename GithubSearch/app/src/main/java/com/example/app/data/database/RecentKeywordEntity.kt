package com.example.app.data.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "recent_keywords")
data class RecentKeywordEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "search_id")
    val id: Long = 0L,
    @ColumnInfo(name = "keyword")
    val keyword: String,
    @ColumnInfo(name = "searched_at")
    val searchedAt: Long = System.currentTimeMillis(),
)
