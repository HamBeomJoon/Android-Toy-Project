package com.example.githubSearch.presentation.view.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.example.githubSearch.domain.model.UserInfo
import com.example.githubSearch.domain.repository.UserRepository
import com.example.githubSearch.presentation.SingleLiveData
import com.example.githubSearch.presentation.model.RandomUser
import com.example.githubSearch.presentation.view.UiState
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _uiState = MutableLiveData<UiState<Unit>>(UiState.Loading)
    val uiState: LiveData<UiState<Unit>> = _uiState

    val isLoading = uiState.map { it is UiState.Loading }

    private val _usersInfo = MutableLiveData<List<RandomUser>>()
    val usersInfo: LiveData<List<RandomUser>> = _usersInfo

    private val _toastMessage = SingleLiveData<String>()
    val toastMessage: LiveData<String> = _toastMessage

    init {
        fetchUsers()
    }

    fun fetchUsers() {
        _uiState.value = UiState.Loading

        viewModelScope.launch {
            userRepository
                .fetchRandomUsers()
                .onSuccess { usersInfo ->
                    val randomUsers = mapToRandomUserList(usersInfo)
                    _usersInfo.value = randomUsers
                    _uiState.value = UiState.Success(Unit)
                }.onFailure {
                    _uiState.value = UiState.Failure(it)
                }
        }
    }

    private suspend fun mapToRandomUserList(usersInfo: List<UserInfo>): List<RandomUser> =
        coroutineScope {
            usersInfo
                .map { userInfo ->
                    async {
                        toRandomUser(userInfo)
                            .onFailure {
                                _toastMessage.value = "유저 정보를 불러오지 못했습니다: ${userInfo.userId}"
                            }
                    }
                }.awaitAll()
                .mapNotNull {
                    it.getOrNull()
                }
        }

    private suspend fun toRandomUser(userInfo: UserInfo): Result<RandomUser> =
        runCatching {
            val userDetail = userRepository.getUser(userInfo.userId).getOrThrow()
            RandomUser(
                profile = userInfo.profile,
                userId = userInfo.userId,
                followers = userDetail.followers,
            )
        }
}
