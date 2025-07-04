package com.example.githubSearch.presentation.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubSearch.di.RepositoryModule

class DetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userRepository = RepositoryModule.userRepository
        return DetailViewModel(userRepository) as T
    }
}
