package com.example.app.presentation.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.repository.UserRepository
import com.example.app.presentation.view.UiState
import kotlinx.coroutines.launch

class DetailViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState<Unit>>(UiState.Loading)
    val uiState: LiveData<UiState<Unit>> get() = _uiState

    fun searchUser(username: String) {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            userRepository
                .getUser(username)
                .onSuccess {
                    _uiState.value = UiState.Success(Unit)
                }.onFailure {
                    _uiState.value = UiState.Failure(it)
                }
        }
    }
}
