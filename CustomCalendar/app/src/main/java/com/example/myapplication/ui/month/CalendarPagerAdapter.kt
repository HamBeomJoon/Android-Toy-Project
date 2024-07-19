package com.example.myapplication.ui.month

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.CalendarPageBinding
import com.example.myapplication.ui.day.DayRecyclerViewAdapter
import java.util.Date

class CalendarPagerAdapter(
    private val datesList: List<List<Date>>,
    private val currentMonth: Int
) : RecyclerView.Adapter<CalendarPagerAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: CalendarPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val calendarRecyclerView: RecyclerView = binding.calendarViewPager
        val dayOfTheWeekRecyclerView: RecyclerView = binding.dayOfTheWeekRecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            CalendarPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val dates = datesList[position]
        val adapter = CalendarAdapter(dates, currentMonth)

        holder.calendarRecyclerView.adapter = adapter
        holder.calendarRecyclerView.layoutManager = GridLayoutManager(holder.itemView.context, 7)


        val daysOfWeek = listOf("월", "화", "수", "목", "금", "토", "일")
        val dayOfWeekAdapter = DayRecyclerViewAdapter(daysOfWeek)
        holder.dayOfTheWeekRecyclerView.adapter = dayOfWeekAdapter
        holder.dayOfTheWeekRecyclerView.layoutManager =
            GridLayoutManager(holder.itemView.context, 7)

    }

    override fun getItemCount(): Int {
        return datesList.size
    }
}