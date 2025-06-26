package com.example.loginEx.bindingadapter

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.loginEx.R
import com.navercorp.nid.oauth.NidOAuthLoginState
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.Date
import java.util.Locale

@BindingAdapter("kakaoAccessExpiresText")
fun setKakaoAccessExpiresText(
    view: TextView,
    time: Date?,
) {
    val context = view.context
    if (time == null) {
        view.text = ""
        return
    }

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    view.text =
        context.getString(R.string.result_kakao_access_token_expires, formatter.format(time))
}

@BindingAdapter("kakaoRefreshExpiresText")
fun setKakaoRefreshExpiresText(
    view: TextView,
    time: Date?,
) {
    val context = view.context
    if (time == null) {
        view.text = ""
        return
    }

    val formatter = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    view.text =
        context.getString(R.string.result_kakao_refresh_token_expires, formatter.format(time))
}

@BindingAdapter("kakaoScopesText")
fun setKakaoScopes(
    view: TextView,
    scopes: List<String>?,
) {
    val context = view.context
    if (!scopes.isNullOrEmpty()) {
        view.text =
            context.getString(
                R.string.result_kakao_agrees,
                scopes.joinToString(", "),
            )
    } else {
        view.text = "동의항목 없음"
    }
}

@BindingAdapter("expiresDateText")
fun setExpiresDateText(
    view: TextView,
    timestamp: Long?,
) {
    if (timestamp == null) {
        view.text = ""
        return
    }

    val context = view.context

    val date =
        Instant
            .ofEpochSecond(timestamp)
            .atZone(ZoneId.systemDefault())
            .toLocalDate()

    view.text = context.getString(R.string.result_naver_token_expires, date)
}

@BindingAdapter("stateText")
fun setStateText(
    view: TextView,
    state: NidOAuthLoginState?,
) {
    val context = view.context

    val stateText =
        when (state) {
            NidOAuthLoginState.NEED_INIT -> "초기화 필요"
            NidOAuthLoginState.NEED_LOGIN -> "로그인 필요"
            NidOAuthLoginState.NEED_REFRESH_TOKEN -> "토큰 갱신 필요"
            NidOAuthLoginState.OK -> "정상"
            null -> ""
        }

    view.text = context.getString(R.string.result_naver_state, stateText)
}

@BindingAdapter("visibleGone")
fun setVisibleGone(
    view: TextView,
    visible: Boolean,
) {
    view.isVisible = visible
}
