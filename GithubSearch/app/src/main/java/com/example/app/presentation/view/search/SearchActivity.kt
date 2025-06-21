package com.example.app.presentation.view.search

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivitySearchBinding
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.ItemClickListener
import com.example.app.presentation.view.detail.DetailActivity
import com.google.android.material.snackbar.Snackbar

class SearchActivity :
    BaseActivity<ActivitySearchBinding>(R.layout.activity_search),
    ItemClickListener {
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    override fun initView() {
        super.initView()
        setupBinding()
        setObserve()
    }

    override fun initListener() {
        super.initListener()
        binding.ibBack.setOnClickListener { finish() }
        binding.ibSearch.setOnClickListener { handleSearchClick() }
    }

    private fun setupBinding() {
        binding.vm = viewModel
    }

    private fun handleSearchClick() {
        if (viewModel.isValidQuery()) {
            val query = viewModel.searchQuery.value.orEmpty()
            viewModel.saveRecentKeyword(query)
            val intent = DetailActivity.newIntent(this, query)
            startActivity(intent)
            finish()
        } else {
            showToast(getString(R.string.search_toast_empty_query))
        }
    }

    private fun setObserve() {
        viewModel.toastMessage.observe(this) { message ->
            showSnackBar(message)
        }
    }

    override fun onSelected(value: String) {
        TODO("Not yet implemented")
    }

    private fun showSnackBar(message: String) {
        Snackbar
            .make(binding.root, message, Snackbar.LENGTH_SHORT)
            .setAction("확인") {}
            .show()
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }
}
