package com.example.app.presentation.view.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.app.di.RepositoryModule

class MainViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val userRepository = RepositoryModule.userRepository
        return MainViewModel(userRepository) as T
    }
}
