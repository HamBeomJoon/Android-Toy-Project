package com.example.app.presentation.view.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.domain.repository.RecentKeywordRepository

class SearchViewModel(
    private val recentKeywordRepository: RecentKeywordRepository,
) : ViewModel() {
    val searchQuery = MutableLiveData("")

    fun isValidQuery(): Boolean = !searchQuery.value.isNullOrBlank()
}
