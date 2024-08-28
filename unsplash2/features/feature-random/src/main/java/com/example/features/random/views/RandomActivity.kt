package com.example.features.random.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.features.random.R
import com.example.features.random.databinding.ActivityRandomBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RandomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRandomBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRandomBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

    }
}