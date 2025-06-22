package com.example.naverlogin.views.result

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.example.naverlogin.R
import com.example.naverlogin.databinding.ActivityResultBinding
import com.example.naverlogin.getParcelableExtraCompat
import com.example.naverlogin.model.GoogleLoginResult
import com.example.naverlogin.model.LoginType
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

        val loginType = intent.getParcelableExtraCompat<LoginType>(EXTRA_LOGIN_TYPE)
        viewModel.setLoginType(loginType)

        when (loginType) {
            LoginType.NAVER -> {
                val result =
                    intent.getParcelableExtraCompat<NaverLoginResult>(EXTRA_NAVER_LOGIN_RESULT)
                viewModel.setNaverResult(result)
            }

            LoginType.GOOGLE -> {
                val result =
                    intent.getParcelableExtraCompat<GoogleLoginResult>(EXTRA_GOOGLE_LOGIN_RESULT)
                viewModel.setGoogleResult(result)
            }

            else -> {}
        }
    }

    private fun initInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    companion object {
        const val EXTRA_LOGIN_TYPE = "login_type"
        const val EXTRA_NAVER_LOGIN_RESULT = "naver_login_result"
        const val EXTRA_GOOGLE_LOGIN_RESULT = "google_login_result"

        fun newIntent(
            context: Context,
            loginType: LoginType,
            naverResult: NaverLoginResult? = null,
            googleResult: GoogleLoginResult? = null,
        ): Intent =
            Intent(context, ResultActivity::class.java).apply {
                putExtra(EXTRA_LOGIN_TYPE, loginType as Parcelable)
                naverResult?.let { putExtra(EXTRA_NAVER_LOGIN_RESULT, it) }
                googleResult?.let { putExtra(EXTRA_GOOGLE_LOGIN_RESULT, it) }
            }
    }
}
