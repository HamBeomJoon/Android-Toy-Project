package com.example.app.presentation.view.detail

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.app.domain.model.RepositoryInfo
import com.example.app.presentation.view.ItemClickListener

class RepoAdapter(
    private val itemClickListener: ItemClickListener,
) : ListAdapter<RepositoryInfo, RepoViewHolder>(RepoDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): RepoViewHolder = RepoViewHolder.create(parent, itemClickListener)

    override fun onBindViewHolder(
        holder: RepoViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item)
    }
}
