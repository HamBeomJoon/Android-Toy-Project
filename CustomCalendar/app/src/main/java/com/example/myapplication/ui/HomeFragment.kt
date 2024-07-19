package com.example.myapplication.ui

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding
import com.example.myapplication.ui.month.CalendarPagerAdapter
import com.example.myapplication.util.BaseFragment
import com.example.myapplication.util.Dates
import java.util.Calendar
import java.util.Date

class HomeFragment : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private var calendar = Calendar.getInstance()
    private val startCalendar: Calendar = Calendar.getInstance().apply {
        time = Date()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        startCalendar.time = calendar.time

        binding.calendarViewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.calendarViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 12 + position)
                updateCalendar()
            }
        })

        updateCalendar() // 초기 달력 업데이트

    }

    private fun updateCalendar() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        binding.yearMonthTextView.text = "${year}년 ${month + 1}월"

        val months = generateMonths(calendar)
        val pagerAdapter = CalendarPagerAdapter(months, month)
        binding.calendarViewPager.adapter = pagerAdapter
        binding.calendarViewPager.setCurrentItem(months.size / 2, false)
    }

    private fun generateMonths(calendar: Calendar): List<List<Date>> {

        val months = mutableListOf<List<Date>>()

        for (i in -12..12) {
            val cal = calendar.clone() as Calendar
            cal.add(Calendar.MONTH, i)
            months.add(Dates.generateDates(cal))
        }
        return months
    }
}