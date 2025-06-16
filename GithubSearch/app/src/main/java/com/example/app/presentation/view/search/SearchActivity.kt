package com.example.app.presentation.view.search

import android.content.Context
import android.content.Intent
import androidx.activity.viewModels
import com.example.app.R
import com.example.app.databinding.ActivitySearchBinding
import com.example.app.presentation.view.BaseActivity

class SearchActivity : BaseActivity<ActivitySearchBinding>(R.layout.activity_search) {
    private val viewModel: SearchViewModel by viewModels { SearchViewModelFactory() }

    override fun initView() {
        super.initView()

        binding.ibBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent = Intent(context, SearchActivity::class.java)
    }
}
