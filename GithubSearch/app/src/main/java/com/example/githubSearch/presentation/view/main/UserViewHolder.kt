package com.example.githubSearch.presentation.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubSearch.databinding.ItemUsersBinding
import com.example.githubSearch.presentation.model.RandomUser
import com.example.githubSearch.presentation.view.ItemClickListener

class UserViewHolder(
    private val binding: ItemUsersBinding,
    itemClickListener: ItemClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(item: RandomUser) {
        binding.userInfo = item
    }

    companion object {
        fun create(
            parent: ViewGroup,
            itemClickListener: ItemClickListener,
        ): UserViewHolder =
            UserViewHolder(
                binding =
                    ItemUsersBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false,
                    ),
                itemClickListener = itemClickListener,
            )
    }
}
