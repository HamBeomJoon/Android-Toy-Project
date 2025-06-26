package com.example.loginEx.bindingadapter

import android.content.Context
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.loginEx.R
import com.navercorp.nid.oauth.NidOAuthLoginState
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.Date

private fun formatDate(
    context: Context,
    date: Date?,
): String {
    val locale = context.resources.configuration.locales[0]
    val formatter = SimpleDateFormat("yyyy-MM-dd", locale)
    return date?.let { formatter.format(it) }.orEmpty()
}

@BindingAdapter("kakaoAccessExpiresText")
fun setKakaoAccessExpiresText(
    view: TextView,
    time: Date?,
) {
    view.text =
        view.context.getString(
            R.string.result_kakao_access_token_expires,
            formatDate(view.context, time),
        )
}

@BindingAdapter("kakaoRefreshExpiresText")
fun setKakaoRefreshExpiresText(
    view: TextView,
    time: Date?,
) {
    view.text =
        view.context.getString(
            R.string.result_kakao_refresh_token_expires,
            formatDate(view.context, time),
        )
}

@BindingAdapter("kakaoScopesText")
fun setKakaoScopes(
    view: TextView,
    scopes: List<String>?,
) {
    val context = view.context
    view.text =
        if (!scopes.isNullOrEmpty()) {
            context.getString(R.string.result_kakao_agrees, scopes.joinToString(", "))
        } else {
            context.getString(R.string.result_kakao_agrees, "없음")
        }
}

@BindingAdapter("expiresDateText")
fun setExpiresDateText(
    view: TextView,
    timestamp: Long?,
) {
    val context = view.context
    val dateText =
        timestamp
            ?.let {
                Instant
                    .ofEpochSecond(it)
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate()
                    .toString()
            }.orEmpty()

    view.text = context.getString(R.string.result_naver_token_expires, dateText)
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
