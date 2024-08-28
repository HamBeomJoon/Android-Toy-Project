package com.example.unsplash.core.data.repository.api

import com.example.unsplash.core.model.PhotoDetailEntity
import com.example.unsplash.core.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {
    suspend fun flowGetPhotos(currentPage: Int): Flow<List<PhotoEntity>>

    suspend fun flowGetRandomPhotos(): Flow<List<PhotoEntity>>

    suspend fun flowGetPhotoDetail(photoId: String): Flow<PhotoDetailEntity>
}