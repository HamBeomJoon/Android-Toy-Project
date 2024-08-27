package com.example.unsplash.core.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.unsplash.core.database.model.PhotoDaoEntity

@Dao
interface PhotoDao {
    @Query("select * from bookmarkPhoto")
    fun getBookmarkList(): List<PhotoDaoEntity>     // 북마크 사진들 출력

    @Query("select exists(select 1 from bookmarkPhoto where photoId = :photoId)")
    suspend fun searchIsBookmark(photoId: String): Boolean      // id가 db 안에 존재하는 지 조회

    @Insert
    fun addBookmark(photoInfo: PhotoDaoEntity)    // 사진 북마크에 추가

    @Query("delete from bookmarkPhoto where photoId = :photoId")
    fun deleteBookmark(photoId: String)   // 사진 북마크에서 제거

    @Query("DELETE FROM bookmarkPhoto")
    suspend fun deleteAllBookmarks()    // db에서 사진 전체 제거
}