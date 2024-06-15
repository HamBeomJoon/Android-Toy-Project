package com.example.app.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.data.repository.UserRepositoryImpl
import com.example.app.presentation.utils.UiState
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val userRepositoryImpl = UserRepositoryImpl()

    private val _searchState = MutableLiveData<UiState<Unit>>(UiState.Loading)
    val loginState: LiveData<UiState<Unit>> get() = _searchState

    fun searchUsers(username: String) {
        _searchState.value = UiState.Loading

        viewModelScope.launch {
            userRepositoryImpl.searchUsers(username)
//                .onSuccess {
//                    _searchState.value = UiState.Success(Unit)
//                }.onFailure {
//                    _searchState.value = UiState.Failure(it.message)
//                }
        }
    }
}