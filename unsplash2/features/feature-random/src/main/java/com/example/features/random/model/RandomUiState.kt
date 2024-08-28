package com.example.features.random.model

sealed class RandomUiState<out T> {
    data object Loading : RandomUiState<Nothing>()
    data class Success<out T>(val data: T) : RandomUiState<T>()
    data class Failure(val error: String?) : RandomUiState<Nothing>()
}