package com.example.loginEx.views.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.loginEx.model.GoogleLoginResult
import com.example.loginEx.model.LoginType
import com.example.loginEx.model.NaverLoginResult

class ResultViewModel : ViewModel() {
    private val _loginType = MutableLiveData<LoginType>()
    val loginType: LiveData<LoginType> = _loginType

    private val _naverResult = MutableLiveData<NaverLoginResult>()
    val naverResult: LiveData<NaverLoginResult> = _naverResult

    private val _googleResult = MutableLiveData<GoogleLoginResult>()
    val googleResult: LiveData<GoogleLoginResult> = _googleResult

    fun setLoginType(type: LoginType) {
        _loginType.value = type
    }

    fun setNaverResult(result: NaverLoginResult) {
        _naverResult.value = result
    }

    fun setGoogleResult(result: GoogleLoginResult) {
        _googleResult.value = result
    }
}
