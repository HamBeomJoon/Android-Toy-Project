package com.example.presentation.views.home


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.PhotoEntity
import com.example.domain.PhotoRepository
import com.example.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val photoRepository: PhotoRepository,
//    private val bookmarkRepository: BookmarkRepository
) : ViewModel() {
    private val _photoState = MutableLiveData<UiState<List<PhotoEntity>>>(UiState.Loading)
    val photoState: LiveData<UiState<List<PhotoEntity>>> get() = _photoState

//    private val _bookmarkState = MutableLiveData<UiState<List<Photo>>>(UiState.Loading)
//    val bookmarkState: LiveData<UiState<List<Photo>>> get() = _bookmarkState

    fun getPhotos(currentPage: Int) {
        _photoState.value = UiState.Loading

        viewModelScope.launch {
            try {
                photoRepository.getPhotos(currentPage).onSuccess {
                    _photoState.value = UiState.Success(it)
                }.onFailure {
                    _photoState.value = UiState.Failure(it.message)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                _photoState.value = UiState.Failure(e.message)
            }
        }
    }

//    fun getBookmarkPhotos() {
//        _bookmarkState.value = UiState.Loading
//
//        viewModelScope.launch {
//            try {
//                val it = bookmarkRepositoryImpl.getBookmarkPhotos()
//                _bookmarkState.value = UiState.Success(it)
//            } catch (e: Exception) {
//                e.printStackTrace()
//                _bookmarkState.value = UiState.Failure(e.message)
//            }
//        }
}

//    fun addBookmark(photoInfo: PhotoDaoEntity) {
//        viewModelScope.launch {
//            try {
//                bookmarkRepositoryImpl.addBookmark(photoInfo)
//                // 추가한 후 다시 북마크 목록을 로드할 수 있도록 갱신
//                getBookmarkPhotos()
//            } catch (e: Exception) {
//                e.printStackTrace()
//                _bookmarkState.value = UiState.Failure(e.message)
//            }
//        }
//    }
//
//    fun deleteAllBookmarks() {
//        viewModelScope.launch {
//            try {
//                bookmarkRepositoryImpl.deleteAllBookmarks()
//                getBookmarkPhotos()
//            } catch (e: Exception) {
//                e.printStackTrace()
//                _bookmarkState.value = UiState.Failure(e.message)
//            }
//        }
//    }