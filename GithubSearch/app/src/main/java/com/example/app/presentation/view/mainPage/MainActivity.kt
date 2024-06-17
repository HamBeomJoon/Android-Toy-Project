package com.example.app.presentation.view.mainPage

import android.app.Activity
import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.utils.UiState
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.searchPage.SearchActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {
    private val viewModel: MainViewModel by viewModels()
    override fun initView() {
        super.initView()

        binding.ibUserSearch.setOnClickListener {
            moveActivity(SearchActivity())
        }

//        binding.rvMain.adapter = SampleAdapter

        loadSampleData()
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

    private fun loadSampleData() {
        lifecycleScope.launch {
            showSampleData(isLoading = true)

            delay(3000)

//            val samples = getSampleList()
//            (binding.rvMain.adapter as SampleAdapter).replaceAll(samples)

            showSampleData(isLoading = false)
        }
    }

    private fun showSampleData(isLoading: Boolean) {
        if (isLoading) {
            binding.sfLoading.startShimmer()
            binding.sfLoading.visibility = View.VISIBLE
            binding.rvMain.visibility = View.GONE
        } else {
            binding.sfLoading.stopShimmer()
            binding.sfLoading.visibility = View.GONE
            binding.rvMain.visibility = View.VISIBLE
        }
    }
}