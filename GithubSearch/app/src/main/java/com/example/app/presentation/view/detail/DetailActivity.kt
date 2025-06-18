package com.example.app.presentation.view.detail

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import androidx.core.net.toUri
import com.example.app.R
import com.example.app.databinding.ActivityDetailBinding
import com.example.app.presentation.Extras
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.UiState
import com.example.app.presentation.view.main.MainActivity

class DetailActivity :
    BaseActivity<ActivityDetailBinding>(R.layout.activity_detail),
    DetailClickListener {
    private val viewModel: DetailViewModel by viewModels { DetailViewModelFactory() }
    private val repoAdapter: RepoAdapter by lazy { RepoAdapter(this) }

    override fun initView() {
        super.initView()
        setupBinding()
        setupRecyclerView()
        observeUiState()

        val searchQuery = intent.getStringExtra(Extras.EXTRA_QUERY) ?: return
        viewModel.searchUser(searchQuery)
    }

    private fun setupBinding() {
        binding.vm = viewModel
        binding.ibHome.setOnClickListener {
            val intent =
                MainActivity.newIntent(this).apply {
                    flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                }
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() =
        with(binding.rvRepos) {
            adapter = repoAdapter
            itemAnimator = null
        }

    private fun observeUiState() {
        viewModel.uiState.observe(this) { state ->
            if (state is UiState.Failure) {
                showToast(state.throwable?.message.orEmpty())
            }
        }
    }

    override fun onSelected(url: String) {
        try {
            val intent = Intent(Intent.ACTION_VIEW, url.toUri())
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            showToast("브라우저를 열 수 없습니다.")
        }
    }

    companion object {
        fun newIntent(
            context: Context,
            query: String,
        ): Intent =
            Intent(context, DetailActivity::class.java).apply {
                putExtra(Extras.EXTRA_QUERY, query)
            }
    }
}
