package com.example.app.presentation.view.search

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemSearchesBinding
import com.example.app.domain.model.RecentSearch
import com.example.app.presentation.view.ItemClickListener

class RecentSearchViewHolder(
    private val binding: ItemSearchesBinding,
    itemClickListener: ItemClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(item: RecentSearch) {
        binding.recentSearch = item
        Log.d("RecentSearch", "바인딩됨: ${item.keyword}")
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            parent: ViewGroup,
            itemClickListener: ItemClickListener,
        ): RecentSearchViewHolder =
            RecentSearchViewHolder(
                binding =
                    ItemSearchesBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                itemClickListener = itemClickListener,
            )
    }
}
