package com.example.app.presentation.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.app.databinding.ItemUsersBinding
import com.example.app.domain.model.UserInfo

class UserViewHolder(
    private val binding: ItemUsersBinding,
    itemClickListener: UserClickListener,
) : RecyclerView.ViewHolder(binding.root) {
    init {
        binding.itemClickListener = itemClickListener
    }

    fun bind(userInfo: UserInfo) {
        binding.userInfo = userInfo
    }

    companion object {
        fun create(
            parent: ViewGroup,
            itemClickListener: UserClickListener,
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
