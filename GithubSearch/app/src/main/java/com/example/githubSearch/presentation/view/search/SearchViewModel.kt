package com.example.githubSearch.presentation.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubSearch.domain.model.RecentSearch
import com.example.githubSearch.domain.repository.RecentKeywordRepository
import com.example.githubSearch.presentation.SingleLiveData
import kotlinx.coroutines.launch

class SearchViewModel(
    private val recentKeywordRepository: RecentKeywordRepository,
) : ViewModel() {
    private val _recentSearches = MutableLiveData<List<RecentSearch>>()
    val recentSearches: LiveData<List<RecentSearch>> = _recentSearches

    private val _snackBarMessage = SingleLiveData<String>()
    val snackBarMessage: LiveData<String> = _snackBarMessage

    val searchQuery = MutableLiveData("")

    fun isValidQuery(): Boolean = !searchQuery.value.isNullOrBlank()

    init {
        loadRecentSearches()
    }

    fun saveRecentKeyword(keyword: String) {
        viewModelScope.launch {
            recentKeywordRepository
                .addKeyword(keyword)
                .onFailure { _snackBarMessage.value = "최근 검색어 저장에 실패했습니다" }
        }
    }

    fun deleteKeyword(keyword: String) {
        viewModelScope.launch {
            recentKeywordRepository
                .deleteKeyword(keyword)
                .onSuccess {
                    _snackBarMessage.value = "최근 검색어를 삭제했습니다"
                    loadRecentSearches()
                }.onFailure { _snackBarMessage.value = "최근 검색어 삭제에 실패했습니다" }
        }
    }

    fun deleteAllKeywords() {
        viewModelScope.launch {
            recentKeywordRepository
                .clearKeywords()
                .onSuccess {
                    _snackBarMessage.value = "최근 검색어 전체를 삭제했습니다"
                    loadRecentSearches()
                }.onFailure { _snackBarMessage.value = "최근 검색어 전체 삭제에 실패했습니다" }
        }
    }

    private fun loadRecentSearches() {
        viewModelScope.launch {
            recentKeywordRepository
                .getAllKeywords()
                .onSuccess { keywords ->
                    _recentSearches.value = keywords
                }.onFailure { _snackBarMessage.value = "최근 검색어 조회에 실패했습니다." }
        }
    }
}
