package com.example.app.presentation.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("repoNameLimited")
fun setRepoNameLimited(
    view: TextView,
    name: String,
) {
    view.text = name.take(26)
}
