package com.example.naverlogin.views.result

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.naverlogin.model.NaverLoginResult

class ResultViewModel : ViewModel() {
    private val _naverResult = MutableLiveData<NaverLoginResult>()
    val naverResult: LiveData<NaverLoginResult> = _naverResult

    fun setNaverResult(result: NaverLoginResult) {
        _naverResult.value = result
    }
}
