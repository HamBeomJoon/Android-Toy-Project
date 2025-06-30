package com.example.data.repository

import com.example.data.datasource.PhotoRemoteDatasource
import com.example.data.dto.detailPhoto.toDomain
import com.example.data.dto.photos.toDomain
import com.example.data.dto.randomPhoto.toDomain
import com.example.data.handleResult
import com.example.domain.DetailPhoto
import com.example.domain.PhotoRepository
import com.example.domain.RandomPhoto
import javax.inject.Inject

class PhotoRepositoryImpl
    @Inject
    constructor(
        private val photoRemoteDatasource: PhotoRemoteDatasource,
    ) : PhotoRepository {
        override suspend fun getPhotos(): Result<List<RandomPhoto>> =
            handleResult {
                val response = photoRemoteDatasource.getPhotos().getOrThrow()
                response.map { it.toDomain() }
            }

        override suspend fun getRandomPhoto(): Result<RandomPhoto> =
            handleResult {
                val response = photoRemoteDatasource.getRandomPhoto().getOrThrow()
                response.toDomain()
            }

        override suspend fun getPhotoDetail(photoId: String): Result<DetailPhoto> =
            handleResult {
                val response = photoRemoteDatasource.getDetailPhoto(photoId).getOrThrow()
                response.toDomain()
            }
    }
