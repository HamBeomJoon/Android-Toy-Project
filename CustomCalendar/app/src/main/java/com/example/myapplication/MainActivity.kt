package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var questAdapter: QuestRvAdapter
    private lateinit var monthAdapter: AdapterMonth
    private val questList = mutableListOf<Quest>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initRecycler()

        // bgm 재생
        startService(Intent(this, MyService::class.java))
    }

    private fun initRecycler() {
        monthAdapter = AdapterMonth(this)
        val monthListManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.calendarCustom.apply {
            layoutManager = monthListManager
            adapter = monthAdapter
            scrollToPosition(Int.MAX_VALUE / 2)
        }
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.calendarCustom)

        questAdapter = QuestRvAdapter(this)
        val questManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvQuest.apply {
            layoutManager = questManager
            adapter = questAdapter
        }

        questList.apply {
            add(Quest("퀘스트 예시", "EXP 000"))
            add(Quest("퀘스트 예시", "EXP 000"))
            add(Quest("퀘스트 예시", "EXP 000"))
        }
        questAdapter.datas = questList
        questAdapter.notifyDataSetChanged()
    }
}