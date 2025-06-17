package com.example.app.presentation.view.detail

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemRepositoryBinding
import com.example.app.domain.model.RepositoryInfo

class RepoViewHolder(
    private val binding: ItemRepositoryBinding,
    itemClickListener: RepoClickListener,
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
            itemClickListener: RepoClickListener,
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
