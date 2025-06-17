package com.example.app.presentation.view.detail

import androidx.recyclerview.widget.DiffUtil
import com.example.app.domain.model.RepositoryInfo

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
