package com.example.myapplication

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemDayBinding
import java.util.Date

class AdapterDay(val tempMonth: Int, val dayList: MutableList<Date>) :
    RecyclerView.Adapter<AdapterDay.DayView>() {
    private val ROW = 6

    inner class DayView(val binding: ListItemDayBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        val binding = ListItemDayBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayView(binding)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        with(holder.binding) {
            itemDayLayout.setOnClickListener {
                Toast.makeText(holder.itemView.context, "${dayList[position]}", Toast.LENGTH_SHORT)
                    .show()
            }
            itemDayText.text = dayList[position].date.toString()

            itemDayText.setTextColor(
                when (position % 7) {
                    0 -> Color.RED
                    6 -> Color.BLUE
                    else -> Color.BLACK
                }
            )

            if (tempMonth != dayList[position].month) {
                itemDayText.alpha = 0.4f
            } else {
                itemDayText.alpha = 1.0f
            }
        }
    }

    override fun getItemCount(): Int {
        return ROW * 7
    }
}