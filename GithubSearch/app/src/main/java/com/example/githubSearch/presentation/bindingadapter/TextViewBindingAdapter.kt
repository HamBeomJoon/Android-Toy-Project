package com.example.githubSearch.presentation.bindingadapter

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("formattedDate")
fun setFormattedDate(
    view: TextView,
    date: String?,
) {
    view.text = date?.substringBefore("T") ?: ""
}

@BindingAdapter("visible")
fun setVisible(
    view: View,
    text: String?,
) {
    view.isVisible = text != null
}
