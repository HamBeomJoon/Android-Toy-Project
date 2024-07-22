package com.example.domain

interface PhotoRepository {

    suspend fun getPhotos(currentPage: Int): Result<List<PhotoEntity>>
    suspend fun getRandomPhotos(): Result<List<PhotoEntity>>
}