package com.example.core.data.api

import com.example.app.data.model.PhotoDetailDTO.ResponseDetailDTO
import com.example.core.data.api.model.ResponsePhotoDTOItem
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface UnsplashService {
    @GET("/photos")
    suspend fun getPhotos(
        @Header("Accept-Version") version: String,
        @Header("Authorization") clientId: String,
        @Query("page") page: Int,
        @Query("per_page") count: Int = 8,
    ): List<ResponsePhotoDTOItem>

    @GET("photos/random")
    suspend fun getRandomPhotos(
        @Header("Accept-Version") version: String,
        @Header("Authorization") clientId: String,
        @Query("count") count: Int = 5,
    ): List<ResponsePhotoDTOItem>

    @GET("photos/{id}")
    suspend fun getPhotoDetail(
        @Header("Accept-Version") version: String,
        @Header("Authorization") clientId: String,
        @Path("id") id: String,
    ): ResponseDetailDTO
}