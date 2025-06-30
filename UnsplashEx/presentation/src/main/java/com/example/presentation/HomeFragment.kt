package com.example.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.presentation.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?,
    ) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentHomeBinding.bind(view)

        // 뷰 초기화 코드 여기에 작성
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
