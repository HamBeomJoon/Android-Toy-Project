package com.example.data.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmarkPhoto")
data class PhotoDaoEntity(
    @PrimaryKey
    val photoId: String,
    @ColumnInfo
    val thumb: String,
)