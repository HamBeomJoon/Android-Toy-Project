package com.example.core.domain.usecase

import com.example.app.domain.model.PhotoEntity
import com.example.unsplash.core.data.repository.api.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetRandomPhotoUseCase @Inject constructor(
    private val photoRepository: PhotoRepository,
) {
    suspend fun invoke(): Flow<List<PhotoEntity>> =
        photoRepository.flowGetRandomPhotos()
}