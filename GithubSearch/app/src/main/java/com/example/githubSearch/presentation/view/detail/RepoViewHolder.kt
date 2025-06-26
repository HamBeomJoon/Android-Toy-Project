package com.example.githubSearch.presentation.view.detail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubSearch.databinding.ItemRepositoryBinding
import com.example.githubSearch.domain.model.RepositoryInfo
import com.example.githubSearch.presentation.view.ItemClickListener

class RepoViewHolder(
    private val binding: ItemRepositoryBinding,
    itemClickListener: ItemClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(item: RepositoryInfo) {
        binding.markLanguage.setColorFilter(Color.TRANSPARENT)
        binding.repositoryInfo = item
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
            itemClickListener: ItemClickListener,
        ): RepoViewHolder =
            RepoViewHolder(
                binding =
                    ItemRepositoryBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                itemClickListener = itemClickListener,
            )
    }
}
