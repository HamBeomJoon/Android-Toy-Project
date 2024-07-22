package com.example.data.repository

import com.example.data.BuildConfig
import com.example.data.api.PhotoService
import com.example.data.mapper.PhotoMapper
import com.example.domain.PhotoEntity
import com.example.domain.PhotoRepository
import org.json.JSONObject
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoService: PhotoService
) : PhotoRepository {

    override suspend fun getPhotos(currentPage: Int): Result<List<PhotoEntity>> {
        val res =
            photoService.getPhotos(
                "v1",
                "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}",
                currentPage
            )
        return if (res.isSuccessful) {
            if (res.body() == null) Result.success(listOf())
            else Result.success(PhotoMapper.mapperToResponseEntity(res.body()!!))
        } else {
            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
            Result.failure(java.lang.Exception(errorMsg))
        }
    }

    override suspend fun getRandomPhotos(): Result<List<PhotoEntity>> {
        val res = photoService.getRandomPhotos("v1", "Client-ID ${BuildConfig.UNSPLASH_ACCESS_KEY}")
        return if (res.isSuccessful) {
            if (res.body() == null) Result.success(listOf())
            else Result.success(PhotoMapper.mapperToResponseEntity(res.body()!!))
        } else {
            val errorMsg = JSONObject(res.errorBody()!!.string()).getString("msg")
            Result.failure(java.lang.Exception(errorMsg))
        }
    }

}