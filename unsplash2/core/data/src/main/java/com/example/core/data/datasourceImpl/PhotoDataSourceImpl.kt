package com.example.core.data.datasourceImpl

import com.example.app.data.model.PhotoDetailDTO.ResponseDetailDTO
import com.example.app.data.model.ResponsePhotoDTOItem
import com.example.core.data.api.UnsplashService
import com.example.core.data.datasource.PhotoDataSource
import com.example.unsplash.core.data.BuildConfig
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoDataSourceImpl @Inject constructor(
    private val service: UnsplashService,
) : PhotoDataSource {

    override suspend fun getPhotosFlow(
        page: Int,
        count: Int,
    ): Flow<List<ResponsePhotoDTOItem>> {
        return flow {
            emit(
                service.getPhotos(
                    "v1",
                    "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}",
                    page,
                    count
                )
            )
        }
    }

    override suspend fun getRandomPhotos(
        count: Int,
    ): Flow<List<ResponsePhotoDTOItem>> {
        return flow {
            emit(
                service.getRandomPhotos(
                    "v1",
                    "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}"
                )
            )
        }
    }

    override suspend fun getPhotoDetail(id: String): Flow<ResponseDetailDTO> {
        return flow {
            emit(
                service.getPhotoDetail(
                    "v1",
                    "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}",
                    id
                )
            )
        }
    }

}