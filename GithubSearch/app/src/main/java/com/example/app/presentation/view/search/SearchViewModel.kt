package com.example.app.presentation.view.search

import androidx.lifecycle.ViewModel
import com.example.app.domain.repository.UserRepository

class SearchViewModel(
    private val userRepository: UserRepository,
) : ViewModel()
