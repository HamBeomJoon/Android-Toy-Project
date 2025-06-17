package com.example.app.presentation.bindingadapter

import android.graphics.PorterDuff
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.app.R

@BindingAdapter("imageUrl")
fun setLoadImage(
    view: ImageView,
    url: String?,
) {
    Glide
        .with(view)
        .load(url)
        .fallback(R.drawable.ic_delete)
        .error(R.drawable.ic_delete)
        .into(view)
}

@BindingAdapter("languageColor")
fun setLanguageColor(
    view: ImageView,
    language: String?,
) {
    view.isVisible = language != null

    val colorRes =
        when (language?.lowercase()) {
            "java" -> R.color.java_brown
            "javascript" -> R.color.javascript_yellow
            "kotlin" -> R.color.kotlin_purple
            "css" -> R.color.css_purple
            "html" -> R.color.html_red
            "jupyter notebook" -> R.color.jupyter_orange
            "dart" -> R.color.dart_green
            "python" -> R.color.python_blue
            "typescript" -> R.color.typescript_blue
            else -> R.color.dark_gray // 기본 색상
        }

    val color = ContextCompat.getColor(view.context, colorRes)
    view.setColorFilter(color, PorterDuff.Mode.SRC_IN)
}
