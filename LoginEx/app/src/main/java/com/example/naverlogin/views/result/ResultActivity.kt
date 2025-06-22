package com.example.naverlogin.views.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.naverlogin.R
import com.example.naverlogin.databinding.ActivityResultBinding
import com.example.naverlogin.getParcelableExtraCompat
import com.example.naverlogin.model.NaverLoginResult

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private val viewModel: ResultViewModel by viewModels { ResultViewModelFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_result)
        binding.lifecycleOwner = this
        binding.vm = viewModel

        initInsets()

        intent
            .getParcelableExtraCompat<NaverLoginResult>(EXTRA_NAVER_LOGIN_RESULT)
            .let { viewModel.setNaverResult(it) }
    }

    private fun initInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        const val EXTRA_NAVER_LOGIN_RESULT = "naver_login_result"

        fun newIntent(
            context: Context,
            result: NaverLoginResult,
        ): Intent =
            Intent(context, ResultActivity::class.java).apply {
                putExtra(EXTRA_NAVER_LOGIN_RESULT, result)
            }
    }
}
