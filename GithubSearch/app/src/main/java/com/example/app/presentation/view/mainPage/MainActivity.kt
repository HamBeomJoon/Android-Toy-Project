package com.example.app.presentation.view.mainPage

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.utils.UiState
import com.example.app.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        observer()

        binding.ibUserSearch.setOnClickListener {
            viewModel.searchUsers("HamBeomJoon")
        }
    }

    private fun observer() {
        viewModel.loginState.observe(this) {
            when (it) {
                is UiState.Failure -> {
                    Log.d("TAG1", "유저 검색 실패")
                }
                is UiState.Loading -> {}
                is UiState.Success -> {
                    Log.d("TAG1", "유저 검색 성공")

                }
            }
        }
    }
}