package com.example.core.data.repository

import com.example.unsplash.core.model.PhotoDetailEntity
import com.example.unsplash.core.model.PhotoEntity
import com.example.core.data.datasource.PhotoDataSource
import com.example.unsplash.core.data.repository.api.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class PhotoRepositoryImpl @Inject constructor(
    private val photoDataSource: PhotoDataSource,
) : PhotoRepository {
    override suspend fun flowGetPhotos(currentPage: Int): Flow<List<PhotoEntity>> {
        return photoDataSource.getPhotosFlow(currentPage).map { responsePhotoList ->
            responsePhotoList.map { responsePhoto ->
                PhotoEntity(
                    id = responsePhoto.id,
                    thumb = responsePhoto.urls.thumb,
                    description = responsePhoto.description ?: "",
                    isBookmark = false
                )
            }
        }
    }


    override suspend fun flowGetRandomPhotos(): Flow<List<PhotoEntity>> {
        return photoDataSource.getRandomPhotos().map { responsePhotoList ->
            responsePhotoList.map { responsePhoto ->
                PhotoEntity(
                    id = responsePhoto.id,
                    thumb = responsePhoto.urls.thumb,
                    description = responsePhoto.description ?: "",
                    isBookmark = false
                )
            }
        }
    }

    override suspend fun flowGetPhotoDetail(photoId: String): Flow<PhotoDetailEntity> {
//        photoDataSource.getPhotoDetail(photoId)
        return TODO("Provide the return value")
    }

}