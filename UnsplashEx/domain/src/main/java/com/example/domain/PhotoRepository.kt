package com.example.domain

interface PhotoRepository {
    suspend fun getPhotos(): Result<List<RandomPhoto>>

    suspend fun getRandomPhoto(): Result<RandomPhoto>

    suspend fun getPhotoDetail(photoId: String): Result<DetailPhoto>
}
