package com.example.app.presentation.view.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.RepositoryModule

class DetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userRepository = RepositoryModule.userRepository
        return DetailViewModel(userRepository) as T
    }
}
