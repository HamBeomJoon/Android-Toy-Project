package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val monthListManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = AdapterMonth()

        binding.calendarCustom.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }

        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.calendarCustom)
    }
}