package com.example.unsplash.core.data.repository.api

import com.example.unsplash.core.database.model.PhotoDaoEntity

interface BookmarkRepository {
    suspend fun getBookmarkPhotos(): List<PhotoDaoEntity>
    suspend fun searchIsBookmark(photoId: String): Boolean
    suspend fun addBookmark(photoInfo: PhotoDaoEntity)
    suspend fun deleteBookmark(photoId: String)
    suspend fun deleteAllBookmarks()
}