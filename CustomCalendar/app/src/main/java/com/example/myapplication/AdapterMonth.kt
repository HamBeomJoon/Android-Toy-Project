package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ListItemMonthBinding
import java.util.Calendar
import java.util.Date

class AdapterMonth : RecyclerView.Adapter<AdapterMonth.MonthView>() {
    private val center = Int.MAX_VALUE / 2
    private var calendar = Calendar.getInstance()

    inner class MonthView(val binding: ListItemMonthBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MonthView {
        val binding =
            ListItemMonthBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MonthView(binding)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MonthView, position: Int) {
        calendar.time = Date()
        calendar.set(Calendar.DAY_OF_MONTH, 1)
        calendar.add(Calendar.MONTH, position - center)
        holder.binding.itemMonthText.text =
            "${calendar.get(Calendar.YEAR)}년 ${calendar.get(Calendar.MONTH) + 1}월"
        val tempMonth = calendar.get(Calendar.MONTH)

        val dayList: MutableList<Date> = MutableList(6 * 7) { Date() }
        calendar.add(Calendar.DAY_OF_MONTH, 1 - calendar.get(Calendar.DAY_OF_WEEK))
        for (i in 0..5) {
            for (k in 0..6) {
                dayList[i * 7 + k] = calendar.time
                calendar.add(Calendar.DAY_OF_MONTH, 1)
            }
        }

        val dayListManager = GridLayoutManager(holder.binding.root.context, 7)
        val dayListAdapter = AdapterDay(tempMonth, dayList)

        holder.binding.itemMonthDayList.apply {
            layoutManager = dayListManager
            adapter = dayListAdapter
        }

        // bgm 재생
        holder.binding.btnPlayMusic.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, MyService::class.java)
            context.startService(intent)
        }

        // bgm 정지
        holder.binding.btnStopMusic.setOnClickListener {
            val context = holder.binding.root.context
            val intent = Intent(context, MyService::class.java)
            context.stopService(intent)
        }
    }

    override fun getItemCount(): Int {
        return Int.MAX_VALUE
    }
}