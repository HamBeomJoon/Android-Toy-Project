package com.example.githubSearch.presentation.bindingadapter

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.facebook.shimmer.ShimmerFrameLayout

@BindingAdapter("hideWhenLoading")
fun hideWhenLoading(
    view: View,
    isLoading: Boolean,
) {
    view.isVisible = !isLoading
}

@BindingAdapter("shimmerLoading")
fun setShimmerLoading(
    view: ShimmerFrameLayout,
    isLoading: Boolean,
) {
    if (isLoading) {
        view.startShimmer()
        view.visibility = View.VISIBLE
    } else {
        view.stopShimmer()
        view.visibility = View.GONE
    }
}
