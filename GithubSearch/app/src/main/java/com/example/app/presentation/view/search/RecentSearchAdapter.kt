package com.example.app.presentation.view.search

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.app.domain.model.RecentSearch
import com.example.app.presentation.view.ItemClickListener

class RecentSearchAdapter(
    private val clickListener: ItemClickListener,
) : ListAdapter<RecentSearch, RecentSearchViewHolder>(RecentSearchDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RecentSearchViewHolder = RecentSearchViewHolder.create(parent, clickListener)

    override fun onBindViewHolder(
        holder: RecentSearchViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item)
    }
}
