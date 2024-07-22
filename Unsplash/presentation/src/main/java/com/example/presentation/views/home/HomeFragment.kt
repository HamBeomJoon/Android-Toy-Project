package com.example.presentation.views.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.presentation.databinding.FragmentHomeBinding
import com.example.presentation.utils.UiState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
//    private lateinit var bookmarkRvAdapter: BookmarkRvAdapter
    private lateinit var recentRvAdapter: RecentRvAdapter
    private val homeViewModel: HomeViewModel by activityViewModels()
    private var isLoading = false
    private var currentPage = 1

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(layoutInflater)

        // 어댑터 초기화 및 설정
        setupAdapters()

        observers()
        homeViewModel.getPhotos(currentPage)
//        homeViewModel.getBookmarkPhotos()

//        Handler(Looper.getMainLooper()).postDelayed({
//            binding.tvRecentImage.visibility = View.VISIBLE
//        }, 3000) // 3초 후에 tvRecentImage를 visible로 변경

        return binding.root
    }

    private fun setupAdapters() {
//        bookmarkRvAdapter = BookmarkRvAdapter().apply {
//            setItemClickListener(object : OnItemClickListener {
//                override fun onItemClick(id: String) {
//                    showDetail(id)
//                }
//            })
//        }

//        recentRvAdapter = RecentRvAdapter().apply {
//            setItemClickListener(object : OnItemClickListener {
//                override fun onItemClick(id: String) {
//                    showDetail(id)
//                }
//            })
//        }

        binding.rvBookmark.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.HORIZONTAL, false
        )
//        binding.rvBookmark.adapter = bookmarkRvAdapter

        binding.rvRecentImage.adapter = recentRvAdapter
    }

//    private fun showDetail(photoId: String) {
//        DetailFragment(photoId).show(
//            parentFragmentManager, "DetailDialog"
//        )
//    }


    private fun setupScrollListener() {
        binding.rvRecentImage.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)

                val layoutManager = recyclerView.layoutManager as GridLayoutManager
                if (!isLoading) {
                    if (layoutManager.findLastCompletelyVisibleItemPosition() == recentRvAdapter.itemCount - 1
                    ) {
                        currentPage++
                        homeViewModel.getPhotos(currentPage)
                        isLoading = true
                    }

                }
            }
        })
    }

    private fun observers() {
        homeViewModel.photoState.observe(viewLifecycleOwner) {
            when (it) {
                is UiState.Failure -> {
                    Log.d("HomeFragment", "사진 로딩 실패")
                    isLoading = false
                }

                is UiState.Loading -> {}
                is UiState.Success -> {
                    if (currentPage == 1) {
                        recentRvAdapter.setData(it.data)  // 초기 로드
                        setupScrollListener()  // 초기 로드 후 스크롤 리스너 설정
                    } else {
                        recentRvAdapter.addData(it.data)
                    }
                    isLoading = false
                }
            }
        }
//        homeViewModel.bookmarkState.observe(viewLifecycleOwner) {
//            when (it) {
//                is UiState.Failure -> {
//                    Log.d("HomeFragment", "북마크 로딩 실패")
//                }
//
//                is UiState.Loading -> {}
//                is UiState.Success -> {
//                    if (it.data.isEmpty()) {
//                        binding.group1.visibility = View.GONE
//                    } else {
//                        binding.group1.visibility = View.VISIBLE
//                        bookmarkRvAdapter.setData(it.data)
//                    }
//                }
//            }
//        }
    }

    private fun addSampleData() {
//        homeViewModel.deleteAllBookmarks()
        // 샘플 데이터 추가
//        homeViewModel.addBookmark(
//            PhotoDaoEntity(
//                "ZjquxEgXheg",
//                "https://images.unsplash.com/photo-1718489211836-65a20ad6bd8d?crop=entropy&cs=tinysrgb&fit=max&fm=jpg&ixid=M3w2MjAyNzh8MHwxfGFsbHx8fHx8fHx8fDE3MTg5NTEzMTV8&ixlib=rb-4.0.3&q=80&w=200"
//            )
//        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}