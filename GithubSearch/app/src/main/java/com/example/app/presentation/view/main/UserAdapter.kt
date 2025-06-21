package com.example.app.presentation.view.main

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.app.presentation.model.RandomUser
import com.example.app.presentation.view.ItemClickListener

class UserAdapter(
    private val itemClickListener: ItemClickListener,
) : ListAdapter<RandomUser, UserViewHolder>(UserDiffCallback()) {
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
