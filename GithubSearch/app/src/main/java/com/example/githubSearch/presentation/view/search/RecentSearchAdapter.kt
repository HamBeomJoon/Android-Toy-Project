package com.example.githubSearch.presentation.view.search

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.githubSearch.domain.model.RecentSearch
import com.example.githubSearch.presentation.view.ItemClickListener

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
