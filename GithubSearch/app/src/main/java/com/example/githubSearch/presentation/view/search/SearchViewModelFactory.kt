package com.example.githubSearch.presentation.view.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubSearch.di.RepositoryModule

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val recentKeywordRepository = RepositoryModule.recentKeywordRepository
        return SearchViewModel(recentKeywordRepository) as T
    }
}
