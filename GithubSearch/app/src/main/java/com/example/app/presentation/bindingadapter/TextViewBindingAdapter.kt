package com.example.app.presentation.bindingadapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("formattedDate")
fun setFormattedDate(
    view: TextView,
    date: String?,
) {
    view.text = date?.substringBefore("T") ?: ""
}
