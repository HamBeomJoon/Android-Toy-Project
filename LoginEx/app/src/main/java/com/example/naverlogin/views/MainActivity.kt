package com.example.naverlogin.views

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.naverlogin.BuildConfig
import com.example.naverlogin.databinding.ActivityMainBinding
import com.example.naverlogin.model.NaverLoginResult
import com.example.naverlogin.views.result.ResultActivity
import com.google.android.material.snackbar.Snackbar
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initInsets()

        NaverIdLoginSDK.initialize(
            this,
            BuildConfig.NAVER_CLIENT_ID,
            BuildConfig.NAVER_CLIENT_SECRET,
            BuildConfig.NAVER_CLIENT_NAME,
        )
        binding.btnNaverLogin.setOAuthLogin(oauthLoginCallback = oauthLoginCallback)
    }

    private fun initInsets() {
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    /**
     * OAuthLoginCallback을 authenticate() 메서드 호출 시 파라미터로 전달하거나 NidOAuthLoginButton 객체에 등록하면 인증이 종료되는 것을 확인할 수 있습니다.
     */
    private val oauthLoginCallback =
        object : OAuthLoginCallback {
            override fun onSuccess() {
                showToast("네이버 로그인 성공")

                val naverLoginResult =
                    NaverLoginResult(
                        accessToken = NaverIdLoginSDK.getAccessToken(),
                        refreshToken = NaverIdLoginSDK.getRefreshToken(),
                        expires = NaverIdLoginSDK.getExpiresAt(),
                        type = NaverIdLoginSDK.getTokenType(),
                        state = NaverIdLoginSDK.getState(),
                    )

                val intent = ResultActivity.newIntent(this@MainActivity, naverLoginResult)
                startActivity(intent)
            }

            override fun onFailure(
                httpStatus: Int,
                message: String,
            ) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                showSnackBar("errorCode:$errorCode, errorDesc:$errorDescription")
            }

            override fun onError(
                errorCode: Int,
                message: String,
            ) {
                onFailure(errorCode, message)
            }
        }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun showSnackBar(
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        anchorView: View? = null,
    ) {
        val targetView = anchorView ?: binding.root
        Snackbar.make(targetView, message, duration).show()
    }
}
