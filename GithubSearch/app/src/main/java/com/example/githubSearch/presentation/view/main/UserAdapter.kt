package com.example.githubSearch.presentation.view.main

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.githubSearch.presentation.model.RandomUser
import com.example.githubSearch.presentation.view.ItemClickListener

class UserAdapter(
    private val clickListener: ItemClickListener,
) : ListAdapter<RandomUser, UserViewHolder>(UserDiffCallback()) {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): UserViewHolder = UserViewHolder.create(parent, clickListener)

    override fun onBindViewHolder(
        holder: UserViewHolder,
        position: Int,
    ) {
        val item = getItem(position)
        holder.bind(item)
    }
}
