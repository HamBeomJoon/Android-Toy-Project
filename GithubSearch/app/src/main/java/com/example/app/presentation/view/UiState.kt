package com.example.app.presentation.view

sealed class UiState<out T> {
    data object Loading : UiState<Nothing>()

    data class Success<out T>(
        val data: T,
    ) : UiState<T>()

    data class Failure(
        val throwable: Throwable? = null,
    ) : UiState<Nothing>()
}
