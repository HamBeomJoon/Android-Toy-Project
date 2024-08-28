package com.example.core.data.datasource

import com.example.app.data.model.PhotoDetailDTO.ResponseDetailDTO
import com.example.core.data.api.model.ResponsePhotoDTOItem
import kotlinx.coroutines.flow.Flow

interface PhotoDataSource {
    suspend fun getPhotosFlow(
        page: Int,
        count: Int = 8,
    ): Flow<List<ResponsePhotoDTOItem>>

    suspend fun getRandomPhotos(
        count: Int = 5,
    ): Flow<List<ResponsePhotoDTOItem>>

    suspend fun getPhotoDetail(
        id: String,
    ): Flow<ResponseDetailDTO>
}