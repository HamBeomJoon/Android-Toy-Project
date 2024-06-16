package com.example.app.presentation.view.mainPage

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.utils.UiState
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.searchPage.SearchActivity

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    override fun initView() {
        super.initView()

        binding.ibUserSearch.setOnClickListener {
            moveActivity(SearchActivity())
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

    private fun moveActivity(activity: Activity) {
        val intent = Intent(this, activity::class.java)
        startActivity(intent)
        finish()
    }

}