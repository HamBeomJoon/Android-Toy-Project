package com.example.app.presentation.view.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.model.UserDetailInfo
import com.example.app.domain.repository.UserRepository
import com.example.app.presentation.view.UiState
import kotlinx.coroutines.launch

class DetailViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState<Unit>>(UiState.Loading)
    val uiState: LiveData<UiState<Unit>> = _uiState

    private val _userDetailInfo = MutableLiveData<UserDetailInfo>()
    val userDetailInfo: LiveData<UserDetailInfo> = _userDetailInfo

    fun searchUser(userId: String) {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            userRepository
                .getUser(userId)
                .onSuccess { userInfo ->
                    _userDetailInfo.value = userInfo
                    _uiState.value = UiState.Success(Unit)
                }.onFailure {
                    _uiState.value = UiState.Failure(it)
                }
        }
    }
}
