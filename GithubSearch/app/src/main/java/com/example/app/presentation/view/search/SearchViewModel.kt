package com.example.app.presentation.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app.domain.repository.RecentKeywordRepository
import com.example.app.presentation.SingleLiveData
import kotlinx.coroutines.launch

class SearchViewModel(
    private val recentKeywordRepository: RecentKeywordRepository,
) : ViewModel() {
    private val _snackBarMessage = SingleLiveData<String>()
    val snackBarMessage: LiveData<String> = _snackBarMessage

    val searchQuery = MutableLiveData("")

    fun isValidQuery(): Boolean = !searchQuery.value.isNullOrBlank()

    fun saveRecentKeyword(keyword: String) {
        viewModelScope.launch {
            recentKeywordRepository
                .addKeyword(keyword)
                .onFailure { _snackBarMessage.value = "최근 검색어 저장에 실패했습니다" }
        }
    }
}
