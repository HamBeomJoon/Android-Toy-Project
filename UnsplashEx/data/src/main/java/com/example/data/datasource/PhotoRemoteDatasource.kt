package com.example.data.datasource

import com.example.data.dto.detailPhoto.DetailPhotoResponse
import com.example.data.dto.photos.PhotosResponseItem
import com.example.data.dto.randomPhoto.RandomPhotoResponse

interface PhotoRemoteDatasource {
    suspend fun getPhotos(): Result<List<PhotosResponseItem>>

    suspend fun getRandomPhoto(): Result<RandomPhotoResponse>

    suspend fun getDetailPhoto(photoId: String): Result<DetailPhotoResponse>
}
