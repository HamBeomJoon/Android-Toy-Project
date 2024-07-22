package com.example.data.mapper


import com.example.app.data.model.ResponsePhotoDTOItem
import com.example.domain.PhotoEntity

object PhotoMapper {
    fun mapperToResponseEntity(item: List<ResponsePhotoDTOItem>): List<PhotoEntity> {
        val photoList = mutableListOf<PhotoEntity>()
        item.forEach {
            photoList.add(
                PhotoEntity(
                    it.id,
                    it.urls.thumb,
                    it.description ?: "",
                    false,
                )
            )
        }
        return photoList
    }
}