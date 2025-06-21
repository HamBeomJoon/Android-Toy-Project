package com.example.app.presentation.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemUsersBinding
import com.example.app.presentation.model.RandomUser
import com.example.app.presentation.view.ItemClickListener

class UserViewHolder(
    private val binding: ItemUsersBinding,
    itemClickListener: ItemClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(userInfo: RandomUser) {
        binding.userInfo = userInfo
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
