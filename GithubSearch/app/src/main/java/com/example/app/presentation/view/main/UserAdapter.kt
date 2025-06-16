package com.example.app.presentation.view.main

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.app.domain.model.UserInfo

class UserAdapter(
    private val itemClickListener: UserClickListener,
) : ListAdapter<UserInfo, UserViewHolder>(UserDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UserViewHolder = UserViewHolder.create(parent, itemClickListener)

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item)
    }
}
