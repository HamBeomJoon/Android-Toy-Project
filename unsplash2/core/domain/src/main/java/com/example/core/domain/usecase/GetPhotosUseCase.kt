package com.example.core.domain.usecase

import com.example.app.domain.model.PhotoEntity
import com.example.unsplash.core.data.repository.api.PhotoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPhotosUseCase @Inject constructor(
    private val photoRepository: PhotoRepository,
) {
    suspend fun invoke(currentPage: Int): Flow<List<PhotoEntity>> =
        photoRepository.flowGetPhotos(currentPage)
}