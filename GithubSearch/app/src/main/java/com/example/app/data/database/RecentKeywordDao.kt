package com.example.app.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface RecentKeywordDao {
    @Query("SELECT * FROM recent_search ORDER BY searched_at DESC")
    suspend fun getAllRecentKeywords(): List<RecentKeywordEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertKeyword(search: RecentKeywordEntity)

    @Query("DELETE FROM recent_search WHERE keyword = :keyword")
    suspend fun deleteByKeyword(keyword: String)

    @Query("DELETE FROM recent_search")
    suspend fun deleteAllKeywords()
}
