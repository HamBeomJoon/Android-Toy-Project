package com.example.app.presentation.bindingadapter

import android.widget.ImageView
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
