package com.example.myapplication

import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.util.BindingActivity

class MainActivity : BindingActivity<ActivityMainBinding>(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}