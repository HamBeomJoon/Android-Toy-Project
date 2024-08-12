package com.example.naverlogin

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.naverlogin.databinding.ActivityMainBinding
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.OAuthLoginCallback

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        NaverIdLoginSDK.initialize(this, "09Ca4s8gs0pSV50mf6QW", "W7tG2yLIkd", "loginEx")
        binding.btnNaverLogin.setOnClickListener {
            naverLogin()
        }

    }

    private fun naverLogin() {
        /**
         * OAuthLoginCallback을 authenticate() 메서드 호출 시 파라미터로 전달하거나 NidOAuthLoginButton 객체에 등록하면 인증이 종료되는 것을 확인할 수 있습니다.
         */
        val oauthLoginCallback = object : OAuthLoginCallback {
            override fun onSuccess() {
                // 네이버 로그인 인증이 성공했을 때 수행할 코드 추가
                Log.d("addass", "로그인 성공")
                Log.d("asdasd", "AccessToken -> ${NaverIdLoginSDK.getAccessToken()}")
                Log.d("asdasdas", "RefreshToken -> ${NaverIdLoginSDK.getRefreshToken()}")
                Log.d("dasdsaads", "Expires -> ${NaverIdLoginSDK.getExpiresAt()}")
                Log.d("sadasdaas", "Type -> ${NaverIdLoginSDK.getTokenType()}")
                Log.d("dasdsadas", "State -> ${NaverIdLoginSDK.getState()}")
            }

            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(
                    applicationContext,
                    "errorCode:$errorCode, errorDesc:$errorDescription",
                    Toast.LENGTH_SHORT
                ).show()
            }

            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }
        NaverIdLoginSDK.authenticate(this@MainActivity, oauthLoginCallback)
    }

}