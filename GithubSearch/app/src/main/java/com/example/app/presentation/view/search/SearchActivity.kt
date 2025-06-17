package com.example.app.presentation.view.search

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivitySearchBinding
import com.example.app.presentation.view.BaseActivity
import com.example.app.presentation.view.detail.DetailActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    override fun initListener() {
        super.initListener()
        binding.ibBack.setOnClickListener { finish() }

        binding.ibSearch.setOnClickListener {
            handleSearchClick()
        }
    }

    private fun handleSearchClick() {
        val query = binding.etSearchUser.text.toString()

        if (viewModel.isValidQuery(query)) {
            val intent = DetailActivity.newIntent(this, query)
            startActivity(intent)
            finish()
        } else {
            showToast(getString(R.string.search_toast_empty_query))
        }
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }
}
