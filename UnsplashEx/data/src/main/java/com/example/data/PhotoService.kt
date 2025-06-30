package com.example.data

import com.example.data.dto.detailPhoto.DetailPhotoResponse
import com.example.data.dto.photos.PhotosResponseItem
import com.example.data.dto.randomPhoto.RandomPhotoResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoService {
    @GET("/photos")
    suspend fun getRandomPhotos(
        @Query("page") page: Int? = 1,
        @Query("per_page") count: Int? = 10,
    ): Response<List<PhotosResponseItem>>

    @GET("photos/random")
    suspend fun getRandomPhoto(
        @Query("count") count: Int = 5,
    ): Response<RandomPhotoResponse>

    @GET("photos/{id}")
    suspend fun getPhotoDetail(
        @Path("id") photoId: String,
    ): Response<DetailPhotoResponse>
}
