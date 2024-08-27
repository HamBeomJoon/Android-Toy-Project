package com.example.unsplash.core.data.repository.api

import com.example.unsplash.core.model.PhotoDetailEntity
import com.example.app.domain.model.PhotoEntity
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    fun flowGetPhotos(currentPage: Int): Flow<List<PhotoEntity>>

    fun flowGetRandomPhotos(): Flow<List<PhotoEntity>>

    fun flowGetPhotoDetail(photoId: String): Flow<PhotoDetailEntity>
}