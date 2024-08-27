package com.example.core.domain.usecase

import com.example.unsplash.core.model.PhotoDetailEntity
import com.example.unsplash.core.data.repository.api.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetDetailPhotoUseCase @Inject constructor(
    private val photoRepository: PhotoRepository,
) {
    suspend fun invoke(photoId: String): Flow<PhotoDetailEntity> =
        photoRepository.flowGetPhotoDetail(photoId)
}