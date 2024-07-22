package com.example.presentation.views.detail

import android.Manifest
import android.app.Dialog
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.presentation.R
import com.example.presentation.databinding.FragmentDetailBinding
import com.example.presentation.views.MainActivity
import com.example.presentation.views.home.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment(private val photoId: String) : DialogFragment() {
    private var _binding: FragmentDetailBinding? = null
    private var isBookmark: Boolean = false
    private val binding get() = _binding!!
//    private val detailViewModel: DetailViewModel by viewModels()
    private val homeViewModel: HomeViewModel by activityViewModels()
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private val requiredPermissions = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
        arrayOf(Manifest.permission.READ_MEDIA_IMAGES)
    } else {
        arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // false로 설정해 주면 화면밖 혹은 뒤로가기 버튼 시 다이얼로그라 dismiss 되지 않는다.
        isCancelable = false

//        setPermissionLauncher()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return Dialog(requireContext(), R.style.dialog_fullscreen)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        // NavBar 숨기기
        (activity as MainActivity).hideNavBar()
//        detailViewModel.fetchData(photoId)
//        detailViewModel.isBookmark(photoId)

        setupListeners()
        setObservers()

        return binding.root
    }

    private fun setObservers() {
//        detailViewModel.detailState.observe(viewLifecycleOwner) {
//            when (it) {
//                is UiState.Failure -> {
//                    Log.d("DetailFragment", "상세 정보 로딩 실패")
//                }
//
//                is UiState.Loading -> {}
//                is UiState.Success -> {
////                    setDetailImage(it.data)
//                }
//            }
//        }
//
//        detailViewModel.bookmarkState.observe(viewLifecycleOwner) {
//            when (it) {
//                is UiState.Failure -> {
//                    Log.d("DetailFragment", "북마크 상태 로딩 실패")
//                }
//
//                is UiState.Loading -> {}
//                is UiState.Success -> {
//                    isBookmark = it.data
//                    setBookmarkOpacity(isBookmark)
//                }
//            }
//        }
    }

//    private fun setDetailImage(data: PhotoDetailEntity) {
//        Glide.with(binding.ivPhotoDetail.context)
//            .load(data.thumb)
//            .into(binding.ivPhotoDetail)
//        binding.tvPhotoCountry.text = data.country
//        binding.tvPhotoCity.text = data.city
//        binding.tvPhotoDesc.text = data.description
//        binding.tvPhotoLikes.text = data.likes.toString()
//        binding.tvPhotoDownloads.text = data.downloads.toString()
//        binding.tvPhotoTags.text = data.tags.joinToString(" ") { tag -> "#$tag" }
//
//        setBookmark(data.thumb)
//    }

    private fun setBookmarkOpacity(isBookmark: Boolean) {
        val opacity = if (isBookmark) 0.3f else 1.0f
        binding.ivBookmark.alpha = opacity
    }

    private fun setupListeners() {
//        binding.ivExit.setOnClickListener {
//            // NavBar 표시
//            (activity as MainActivity).showNavBar()
//            homeViewModel.getBookmarkPhotos()
//
//            // Remove the fragment
//            dismiss()
//        }

//        binding.ivDownload.setOnClickListener {
//            handleDownloadClick()
//        }
    }

//    private fun handleDownloadClick() {
//        if (PermissionUtils.checkPermissions(requireActivity(), requiredPermissions)) {
//            saveImageToGallery()
//        } else {
//            PermissionUtils.requestPermissions(permissionLauncher, requiredPermissions)
//        }
//    }
//
//    private fun setBookmark(thumb: String) {
//        binding.ivBookmark.setOnClickListener {
//            if (isBookmark) {
//                detailViewModel.deleteBookmark(photoId)
//                Toast.makeText(requireContext(), "북마크에서 삭제 되었습니다", Toast.LENGTH_SHORT).show()
//            } else {
//                detailViewModel.addBookmark(photoId, thumb)
//                Toast.makeText(requireContext(), "북마크에 추가 되었습니다", Toast.LENGTH_SHORT).show()
//            }
//            setBookmarkOpacity(isBookmark)
//            isBookmark = !isBookmark
//        }
//    }

//    private fun saveImageToGallery() {
//        val imageUrl = detailViewModel.detailState.value?.let {
//            if (it is UiState.Success) it.data.thumb else null
//        }
//
//        if (imageUrl != null) {
//            ImageUtils.saveImageToGallery(requireContext(), imageUrl)
//        } else {
//            Toast.makeText(requireContext(), "이미지를 다운로드할 수 없습니다.", Toast.LENGTH_SHORT).show()
//        }
//    }

//    private fun setPermissionLauncher() {
//        permissionLauncher = registerForActivityResult(
//            ActivityResultContracts.RequestMultiplePermissions()
//        ) { permissions ->
//            val allGranted = permissions.values.all { it }
//            if (allGranted) {
//                saveImageToGallery()
//            } else {
//                Toast.makeText(requireContext(), "권한이 거부되었습니다.", Toast.LENGTH_SHORT).show()
//            }
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}