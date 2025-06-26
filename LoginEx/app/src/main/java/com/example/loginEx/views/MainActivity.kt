package com.example.loginEx.views

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.loginEx.BuildConfig
import com.example.loginEx.GoogleSignInHelper
import com.example.loginEx.databinding.ActivityMainBinding
import com.example.loginEx.model.KakaoLoginResult
import com.example.loginEx.model.NaverLoginResult
import com.example.loginEx.views.result.ResultActivity
import com.google.android.material.snackbar.Snackbar
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var googleLoginHelper: GoogleSignInHelper

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

        googleLoginHelper = GoogleSignInHelper(this)

        binding.btnKakaoLogin.setOnClickListener {
            // 카카오계정으로 로그인 공통 callback 구성
            // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
            val kakaoCallback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
                if (error != null) {
                    Log.e("kakao login", "카카오계정으로 로그인 실패", error)
                } else if (token != null) {
                    showToast("카카오 로그인 성공")
                    val intent =
                        ResultActivity.newIntent(
                            context = this@MainActivity,
                            loginResult =
                                KakaoLoginResult(
                                    accessToken = token.accessToken,
                                    accessTokenExpiresAt = token.accessTokenExpiresAt,
                                    refreshToken = token.refreshToken,
                                    refreshTokenExpiresAt = token.refreshTokenExpiresAt,
                                    idToken = token.idToken,
                                    scopes = token.scopes,
                                ),
                        )
                    startActivity(intent)
                }
            }

            // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
            if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
                UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                    if (error != null) {
                        Log.e("kakao login", "카카오톡으로 로그인 실패", error)

                        // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                        // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                        if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                            return@loginWithKakaoTalk
                        }

                        // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                        UserApiClient.instance.loginWithKakaoAccount(this, callback = kakaoCallback)
                    } else if (token != null) {
                        Log.i("kakao login", "카카오톡으로 로그인 성공 ${token.accessToken}")
                    }
                }
            } else {
                UserApiClient.instance.loginWithKakaoAccount(this, callback = kakaoCallback)
            }
        }

        binding.btnGoogleLogin.setOnClickListener {
            googleLoginHelper.requestGoogleLogin(
                onSuccess = { result ->
                    showToast("구글 로그인 성공")
                    val intent =
                        ResultActivity.newIntent(
                            context = this@MainActivity,
                            loginResult = result,
                        )
                    startActivity(intent)
                },
                onFailure = { errorMessage -> showSnackBar(errorMessage) },
            )
        }
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
                        tokenType = NaverIdLoginSDK.getTokenType(),
                        state = NaverIdLoginSDK.getState(),
                    )

                val intent =
                    ResultActivity.newIntent(
                        context = this@MainActivity,
                        loginResult = naverLoginResult,
                    )
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
