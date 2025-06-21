package com.example.app.presentation.view.main

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.ItemClickListener
import com.example.app.presentation.view.UiState
import com.example.app.presentation.view.detail.DetailActivity
import com.example.app.presentation.view.search.SearchActivity

class MainActivity :
    BaseActivity<ActivityMainBinding>(R.layout.activity_main),
    ItemClickListener {
    private val viewModel: MainViewModel by viewModels { MainViewModelFactory() }
    private val userAdapter: UserAdapter by lazy { UserAdapter(this) }

    override fun initView() {
        super.initView()
        setupBinding()
        setupRecyclerView()
        observeUiState()
    }

    override fun initListener() {
        binding.ibUserSearch.setOnClickListener { navigateToSearch() }
    }

    private fun setupBinding() {
        binding.vm = viewModel
    }

    private fun setupRecyclerView() =
        with(binding.rvMain) {
            adapter = userAdapter
            itemAnimator = null
        }

    private fun observeUiState() {
        viewModel.uiState.observe(this) { state ->
            if (state is UiState.Failure) {
                showSnackBar(state.throwable?.message.orEmpty())
            }
        }
    }

    private fun navigateToSearch() {
        startActivity(SearchActivity.newIntent(this))
    }

    override fun onSelected(value: String) {
        val intent = DetailActivity.newIntent(this, value)
        startActivity(intent)
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, MainActivity::class.java)
    }
}
