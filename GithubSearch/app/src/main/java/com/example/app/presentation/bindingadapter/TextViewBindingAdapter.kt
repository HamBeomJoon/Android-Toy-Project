package com.example.app.presentation.bindingadapter

import android.view.View
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import java.time.Instant
import java.time.ZoneId
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
    timestamp: Long?,
) {
    timestamp ?: return
    val dateText = formatDate(timestamp)
    view.text = dateText
}

private fun formatDate(timestamp: Long): String {
    val formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd")
    return Instant
        .ofEpochMilli(timestamp)
        .atZone(ZoneId.systemDefault())
        .toLocalDate()
        .format(formatter)
}
