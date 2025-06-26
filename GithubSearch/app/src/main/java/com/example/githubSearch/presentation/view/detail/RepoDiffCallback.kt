package com.example.githubSearch.presentation.view.detail

import androidx.recyclerview.widget.DiffUtil
import com.example.githubSearch.domain.model.RepositoryInfo

class RepoDiffCallback : DiffUtil.ItemCallback<RepositoryInfo>() {
    override fun areItemsTheSame(
        oldItem: RepositoryInfo,
        newItem: RepositoryInfo,
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: RepositoryInfo,
        newItem: RepositoryInfo,
    ): Boolean = oldItem == newItem
}
