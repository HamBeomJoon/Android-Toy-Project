package com.example.app.presentation.view.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.app.domain.model.UserInfo
import com.example.app.domain.repository.UserRepository
import com.example.app.presentation.SingleLiveData
import com.example.app.presentation.view.UiState
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState<Unit>>(UiState.Loading)
    val uiState: LiveData<UiState<Unit>> get() = _uiState

    val isLoading = uiState.map { it is UiState.Loading }

    private val _usersInfo = MutableLiveData<List<UserInfo>>()
    val usersInfo: LiveData<List<UserInfo>> get() = _usersInfo

    private val _toastMessage = SingleLiveData<Int>()
    val toastMessage: LiveData<Int> = _toastMessage

    init {
        fetchUsers()
    }

    fun searchUser(username: String) {
//        _usersInfo.value = UiState.Loading

        viewModelScope.launch {
            userRepository.getUser(username)
//                .onSuccess {
//                    _searchState.value = UiState.Success(Unit)
//                }.onFailure {
//                    _searchState.value = UiState.Failure(it.message)
//                }
        }
    }

    private fun fetchUsers() {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            userRepository
                .getUsers()
                .onSuccess { usersInfo ->
                    Log.d("meeple_log", "$usersInfo")
                    _usersInfo.value = usersInfo
                    _uiState.value = UiState.Success(Unit)
                }.onFailure {
                    _uiState.value = UiState.Failure(it)
                }
        }
    }
}
