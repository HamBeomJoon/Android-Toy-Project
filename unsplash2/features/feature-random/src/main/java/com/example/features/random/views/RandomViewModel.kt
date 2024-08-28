package com.example.features.random.views

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.domain.usecase.GetRandomPhotoUseCase
import com.example.features.random.model.RandomUiState
import com.example.unsplash.core.model.PhotoEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RandomViewModel @Inject constructor(
    private val getRandomPhotoUseCase: GetRandomPhotoUseCase,
) : ViewModel() {

    private val _randomUiState = MutableStateFlow<RandomUiState<List<PhotoEntity>>>(RandomUiState.Loading)
    val randomUiState: StateFlow<RandomUiState<List<PhotoEntity>>> = _randomUiState.asStateFlow()

    fun getRandomPhotos() {
        _randomUiState.value = RandomUiState.Loading

        viewModelScope.launch {
            try {
                // UseCase 호출 후 결과 처리
                getRandomPhotoUseCase.invoke().collect { photoList ->
                    _randomUiState.value = RandomUiState.Success(photoList)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _randomUiState.value = RandomUiState.Failure(e.message)
            }
        }
    }

}