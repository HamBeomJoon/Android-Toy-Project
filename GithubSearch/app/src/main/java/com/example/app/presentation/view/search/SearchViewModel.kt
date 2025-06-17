package com.example.app.presentation.view.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.app.domain.repository.UserRepository

class SearchViewModel(
    private val userRepository: UserRepository,
) : ViewModel() {
    private val _searchQuery = MutableLiveData<String>()
    val searchQuery: LiveData<String> = _searchQuery

    fun updateQuery(query: String) {
        _searchQuery.value = query
    }

    fun isValidQuery(query: String): Boolean = query.isNotBlank()
}
