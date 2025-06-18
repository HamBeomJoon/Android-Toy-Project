package com.example.app.presentation.view.main

import androidx.recyclerview.widget.DiffUtil
import com.example.app.presentation.model.RandomUser

class UserDiffCallback : DiffUtil.ItemCallback<RandomUser>() {
    override fun areItemsTheSame(
        oldItem: RandomUser,
        newItem: RandomUser,
    ): Boolean = oldItem.userId == newItem.userId

    override fun areContentsTheSame(
        oldItem: RandomUser,
        newItem: RandomUser,
    ): Boolean = oldItem == newItem
}
