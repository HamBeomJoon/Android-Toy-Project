package com.example.core.data.repository

import com.example.app.domain.model.PhotoDetailEntity
import com.example.app.domain.model.PhotoEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface PhotoRepository {

    fun flowGetPhotos(currentPage: Int): Flow<List<PhotoEntity>>

    fun flowGetRandomPhotos(): Flow<List<PhotoEntity>>

    fun flowGetPhotoDetail(photoId: String): Flow<PhotoDetailEntity>
}