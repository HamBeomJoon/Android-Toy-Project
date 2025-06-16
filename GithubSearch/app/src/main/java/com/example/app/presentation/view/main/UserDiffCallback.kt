package com.example.app.presentation.view.main

import androidx.recyclerview.widget.DiffUtil
import com.example.app.domain.model.UserInfo

class UserDiffCallback : DiffUtil.ItemCallback<UserInfo>() {
    override fun areItemsTheSame(
        oldItem: UserInfo,
        newItem: UserInfo,
    ): Boolean = oldItem.userId == newItem.userId

    override fun areContentsTheSame(
        oldItem: UserInfo,
        newItem: UserInfo,
    ): Boolean = oldItem == newItem
}
