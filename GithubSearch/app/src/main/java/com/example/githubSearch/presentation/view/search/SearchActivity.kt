package com.example.githubSearch.presentation.view.search

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.example.githubSearch.R
import com.example.githubSearch.databinding.ActivitySearchBinding
import com.example.githubSearch.presentation.view.BaseActivity
import com.example.githubSearch.presentation.view.ItemClickListener
import com.example.githubSearch.presentation.view.detail.DetailActivity

class SearchActivity :
    BaseActivity<ActivitySearchBinding>(R.layout.activity_search),
    ItemClickListener {
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }
    private val recentSearchAdapter: RecentSearchAdapter by lazy { RecentSearchAdapter(this) }

    override fun initView() {
        super.initView()
        setupBinding()
        setupRecyclerView()
        setObserve()
    }

    override fun initListener() {
        super.initListener()
        binding.ibBack.setOnClickListener { finish() }
        binding.ibSearch.setOnClickListener { handleSearchClick() }
        binding.tvDeleteAllKeywords.setOnClickListener { viewModel.deleteAllKeywords() }
    }

    private fun setupBinding() {
        binding.vm = viewModel
    }

    private fun setupRecyclerView() {
        binding.rvRecentSearch.adapter = recentSearchAdapter
    }

    private fun handleSearchClick() {
        if (viewModel.isValidQuery()) {
            val query = viewModel.searchQuery.value.orEmpty()
            viewModel.saveRecentKeyword(query)
            val intent = DetailActivity.newIntent(this, query)
            startActivity(intent)
            finish()
        } else {
            showSnackBar(getString(R.string.search_snack_bar_empty_query))
        }
    }

    private fun setObserve() {
        viewModel.snackBarMessage.observe(this) { message ->
            showSnackBar(message)
        }
    }

    override fun onSelected(value: String) {
        viewModel.deleteKeyword(value)
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }
}
