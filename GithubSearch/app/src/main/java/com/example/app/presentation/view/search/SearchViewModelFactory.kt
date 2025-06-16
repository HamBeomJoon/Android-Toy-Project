package com.example.app.presentation.view.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.RepositoryModule

class SearchViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userRepository = RepositoryModule.userRepository
        return SearchViewModel(userRepository) as T
    }
}
