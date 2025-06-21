package com.example.app.presentation.bindingadapter

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

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

@BindingAdapter("formattedDate")
fun setFormattedDate(
    view: TextView,
    dateTime: LocalDateTime?,
) {
    dateTime ?: return
    val formatted = formatDate(dateTime)
    view.text = formatted
}

private fun formatDate(dateTime: LocalDateTime): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    return dateTime.format(formatter)
}
