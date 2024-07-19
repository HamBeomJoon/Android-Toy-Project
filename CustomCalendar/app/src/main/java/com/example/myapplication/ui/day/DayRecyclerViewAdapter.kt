package com.example.myapplication.ui.day

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemDayTimeBinding

class DayRecyclerViewAdapter(
    private val timeSlots: List<String>
) : RecyclerView.Adapter<DayRecyclerViewAdapter.ViewHolder>() {


    inner class ViewHolder(private val binding: ItemDayTimeBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(timeSlot: String) {
            binding.timeSlot.text = timeSlot
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDayTimeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(timeSlots[position])
    }

    override fun getItemCount() = timeSlots.size
}