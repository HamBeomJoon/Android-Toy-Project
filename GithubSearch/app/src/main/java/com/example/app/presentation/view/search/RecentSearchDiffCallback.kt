package com.example.app.presentation.view.search

import androidx.recyclerview.widget.DiffUtil
import com.example.app.domain.model.RecentSearch

class RecentSearchDiffCallback : DiffUtil.ItemCallback<RecentSearch>() {
    override fun areItemsTheSame(
        oldItem: RecentSearch,
        newItem: RecentSearch,
    ): Boolean = oldItem.keyword == newItem.keyword

    override fun areContentsTheSame(
        oldItem: RecentSearch,
        newItem: RecentSearch,
    ): Boolean = oldItem == newItem
}
