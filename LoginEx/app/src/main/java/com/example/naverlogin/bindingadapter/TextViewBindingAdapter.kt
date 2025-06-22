package com.example.naverlogin.bindingadapter

import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.naverlogin.R
import com.navercorp.nid.oauth.NidOAuthLoginState
import java.time.Instant
import java.time.ZoneId

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

    view.text = context.getString(R.string.result_naver_expires, date)
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
