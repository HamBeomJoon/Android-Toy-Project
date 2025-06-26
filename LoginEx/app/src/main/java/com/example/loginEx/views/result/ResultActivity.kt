package com.example.loginEx.views.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.loginEx.R
import com.example.loginEx.databinding.ActivityResultBinding
import com.example.loginEx.getParcelableExtraCompat
import com.example.loginEx.model.GoogleLoginResult
import com.example.loginEx.model.KakaoLoginResult
import com.example.loginEx.model.LoginResult
import com.example.loginEx.model.NaverLoginResult

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
        handleIntent()
    }

    private fun initInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    private fun handleIntent() {
        when (val result = intent.getParcelableExtraCompat<LoginResult>(EXTRA_LOGIN_RESULT)) {
            is KakaoLoginResult -> viewModel.setKakaoResult(result)
            is NaverLoginResult -> viewModel.setNaverResult(result)
            is GoogleLoginResult -> viewModel.setGoogleResult(result)
        }
    }

    companion object {
        const val EXTRA_LOGIN_RESULT = "login_result"

        fun newIntent(
            context: Context,
            loginResult: LoginResult,
        ): Intent =
            Intent(context, ResultActivity::class.java).apply {
                putExtra(EXTRA_LOGIN_RESULT, loginResult)
            }
    }
}
