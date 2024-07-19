package com.example.myapplication.ui.month

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CalendarItemBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

class CalendarAdapter(private val dates: List<Date?>, currentMonth: Int) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {

    private val thisMonth = currentMonth

    inner class ViewHolder(private val binding: CalendarItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(date: Date) {
            val calendar = Calendar.getInstance()
            calendar.time = date
            val month = calendar.get(Calendar.MONTH)
            val dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK)

            if (month != thisMonth) {
                binding.dayText.setTextColor(Color.LTGRAY)
            } else {
                when (dayOfWeek) {
                    Calendar.SATURDAY -> {
                        binding.dayText.setTextColor(Color.BLUE)
                    }

                    Calendar.SUNDAY -> {
                        binding.dayText.setTextColor(Color.RED)
                    }

                    else -> {
                        binding.dayText.setTextColor(Color.BLACK)
                    }
                }
            }

            binding.dayText.text = SimpleDateFormat("d", Locale.getDefault()).format(date)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CalendarItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dates[position]!!)
    }

    override fun getItemCount(): Int {
        return dates.size
    }
}