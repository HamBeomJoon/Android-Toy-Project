package com.example.core.data.repository

interface PhotoRepository {
    suspend fun getPhotos(currentPage: Int): Result<List<PhotoEntity>>
    suspend fun getRandomPhotos(): Result<List<PhotoEntity>>
    suspend fun getPhotoDetail(photoId: String): Result<PhotoDetailEntity>
}