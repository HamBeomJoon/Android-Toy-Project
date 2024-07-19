package com.example.myapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemQuestBinding

class QuestRvAdapter(private val context: Context) :
    RecyclerView.Adapter<QuestRvAdapter.ViewHolder>() {
    var datas = mutableListOf<Quest>()

    interface OnItemClickListener {
        fun OnItemClick(url: String)
    }

    var itemClickListener: OnItemClickListener? = null

    inner class ViewHolder(private var binding: ItemQuestBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Quest) {
            binding.tvQuestName.text = item.name
            binding.tvQuestExp.text = item.exp
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemQuestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(datas[position])
    }

    override fun getItemCount(): Int {
        return datas.size
    }
}