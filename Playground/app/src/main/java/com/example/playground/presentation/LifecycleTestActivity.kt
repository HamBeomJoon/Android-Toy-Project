package com.example.playground.presentation

import android.content.Intent
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.playground.databinding.ActivityLifecycleBinding
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class LifecycleTestActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleBinding
    private val lifecycleLog = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifecycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        logLifecycle("onCreate")

        // savedInstanceState 복원
        savedInstanceState?.let {
            val savedLog = it.getStringArrayList("lifecycle_log")
            lifecycleLog.addAll(savedLog ?: emptyList())
            logLifecycle("onCreate - state restored")
        }

        setupUI()
    }

    override fun onStart() {
        super.onStart()
        logLifecycle("onStart")
    }

    override fun onResume() {
        super.onResume()
        logLifecycle("onResume")
    }

    override fun onPause() {
        super.onPause()
        logLifecycle("onPause")
    }

    override fun onStop() {
        super.onStop()
        logLifecycle("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        logLifecycle("onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        logLifecycle("onRestart")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        logLifecycle("onSaveInstanceState")
        outState.putStringArrayList("lifecycle_log", ArrayList(lifecycleLog))
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        logLifecycle("onRestoreInstanceState")
    }

    private fun logLifecycle(event: String) {
        val timestamp =
            SimpleDateFormat("HH:mm:ss.SSS", Locale.getDefault())
                .format(Date())
        val log = "[$timestamp] $event"
        lifecycleLog.add(log)

        Log.d("LifecycleTest", log)
        updateUI()
    }

    private fun setupUI() {
        binding.btnOpenDialog.setOnClickListener {
            AlertDialog
                .Builder(this)
                .setTitle("AlertDialog")
                .setMessage("onPause, onStop 호출되지 않음")
                .setPositiveButton("OK", null)
                .show()
        }

        binding.btnOpenActivity.setOnClickListener {
            // 새 액티비티는 onPause → onStop 호출
            startActivity(Intent(this, SecondActivity::class.java))
        }

        binding.btnRotate.setOnClickListener {
            // 화면 회전 시뮬레이션
            requestedOrientation =
                if (resources.configuration.orientation ==
                    Configuration.ORIENTATION_PORTRAIT
                ) {
                    ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                } else {
                    ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                }
        }

        binding.btnClear.setOnClickListener {
            lifecycleLog.clear()
            updateUI()
        }
    }

    private fun updateUI() {
        binding.tvLog.text = lifecycleLog.joinToString("\n")
        binding.scrollView.post {
            binding.scrollView.fullScroll(View.FOCUS_DOWN)
        }
    }
}
