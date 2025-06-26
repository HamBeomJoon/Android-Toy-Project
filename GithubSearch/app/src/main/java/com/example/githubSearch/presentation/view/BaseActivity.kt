package com.example.githubSearch.presentation.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<T : ViewDataBinding>(
    @LayoutRes private val layoutId: Int,
) : AppCompatActivity() {
    protected lateinit var binding: T

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeSetContentView()
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this

        enableEdgeToEdge()
        initInsets(binding.root)
        initView()
        initViewModel()
        initListener()
    }

    private fun initInsets(targetView: View) {
        ViewCompat.setOnApplyWindowInsetsListener(targetView) { view, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    protected fun showSnackBar(
        message: String,
        duration: Int = Snackbar.LENGTH_SHORT,
        anchorView: View? = null,
    ) {
        val targetView = anchorView ?: binding.root
        Snackbar.make(targetView, message, duration).show()
    }

    protected open fun beforeSetContentView() {}

    protected open fun initView() {}

    protected open fun initViewModel() {}

    protected open fun initListener() {}
}
