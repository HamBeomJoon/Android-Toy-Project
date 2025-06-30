package com.example.data.datasource

import com.example.data.dto.detailPhoto.DetailPhotoResponse
import com.example.data.dto.photos.PhotosResponseItem
import com.example.data.dto.randomPhoto.RandomPhotoResponse
import com.example.data.handleApiCall
import com.example.data.service.PhotoService
import javax.inject.Inject

class PhotoRemoteDatasourceImpl
    @Inject
    constructor(
        private val photoService: PhotoService,
    ) : PhotoRemoteDatasource {
        override suspend fun getPhotos(): Result<List<PhotosResponseItem>> =
            handleApiCall(
                errorMessage = "photos 조회 실패",
                apiCall = { photoService.getRandomPhotos() },
                transform = { response ->
                    response.body()
                        ?: throw IllegalStateException("응답 바디가 null입니다.")
                },
            )

        override suspend fun getRandomPhoto(): Result<RandomPhotoResponse> =
            handleApiCall(
                errorMessage = "Random Photo 조회 실패",
                apiCall = { photoService.getRandomPhoto() },
                transform = { response ->
                    response.body()
                        ?: throw IllegalStateException("응답 바디가 null입니다.")
                },
            )

        override suspend fun getDetailPhoto(photoId: String): Result<DetailPhotoResponse> =
            handleApiCall(
                errorMessage = "Photo Detail 조회 실패",
                apiCall = { photoService.getPhotoDetail(photoId) },
                transform = { response ->
                    response.body()
                        ?: throw IllegalStateException("응답 바디가 null입니다.")
                },
            )
    }
