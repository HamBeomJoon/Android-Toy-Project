package com.example.app.presentation.bindingadapter

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
    view: TextView,
    text: String?,
) {
    view.isVisible = text != null
}
