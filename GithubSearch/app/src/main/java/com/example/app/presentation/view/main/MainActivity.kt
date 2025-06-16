package com.example.app.presentation.view.main

import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.UiState
import com.example.app.presentation.view.search.SearchActivity

class MainActivity :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    UserClickListener {
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }
    private val userAdapter: UserAdapter by lazy { UserAdapter(this) }

    override fun initView() {
        super.initView()

        binding.ibUserSearch.setOnClickListener {
            navigateToSearch()
        }

        setupBinding()
        initAdapter()
        observer()
    }

    private fun setupBinding() {
        binding.lifecycleOwner = this
        binding.vm = viewModel
    }

    private fun initAdapter() {
        binding.rvMain.apply {
            adapter = userAdapter
            itemAnimator = null
        }
    }

    private fun observer() {
        viewModel.uiState.observe(this) {
            when (it) {
                is UiState.Loading -> {
                    showSampleData(true)
                }

                is UiState.Success -> {
                    showSampleData(false)
                }

                is UiState.Failure -> {
                    showToast(it.throwable?.message)
                }
            }
        }
    }

    private fun navigateToSearch() {
        val intent = SearchActivity.newIntent(this)
        startActivity(intent)
    }

    private fun showSampleData(isLoading: Boolean) {
        if (isLoading) {
            binding.sfLoading.startShimmer()
        } else {
            binding.sfLoading.stopShimmer()
            binding.sfLoading.visibility = View.GONE
            binding.rvMain.visibility = View.VISIBLE
        }
    }

    private fun showToast(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onSelected() {
        TODO("Not yet implemented")
    }
}
