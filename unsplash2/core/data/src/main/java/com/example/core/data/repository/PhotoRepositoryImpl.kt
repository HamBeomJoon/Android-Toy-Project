package com.example.core.data.repository

import com.example.unsplash.core.model.PhotoDetailEntity
import com.example.app.domain.model.PhotoEntity
import com.example.core.data.api.UnsplashService
import com.example.unsplash.core.data.repository.api.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class PhotoRepositoryImpl @Inject constructor(
    private val unsplashService: UnsplashService,
) : PhotoRepository {
    override fun flowGetPhotos(currentPage: Int): Flow<List<PhotoEntity>> {
        TODO("Not yet implemented")
    }

    override fun flowGetRandomPhotos(): Flow<List<PhotoEntity>> {
        TODO("Not yet implemented")
    }

    override fun flowGetPhotoDetail(photoId: String): Flow<PhotoDetailEntity> {
        TODO("Not yet implemented")
    }

}