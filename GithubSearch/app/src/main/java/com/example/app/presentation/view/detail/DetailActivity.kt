package com.example.app.presentation.view.detail

import android.content.Context
import android.content.Intent
import com.example.app.R
import com.example.app.databinding.ActivityMainBinding
import com.example.app.presentation.Extras
import com.example.app.presentation.view.BaseActivity

class DetailActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_detail) {
    override fun initView() {
        super.initView()

        val searchQuery = intent.getStringExtra(Extras.EXTRA_QUERY) ?: return
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
