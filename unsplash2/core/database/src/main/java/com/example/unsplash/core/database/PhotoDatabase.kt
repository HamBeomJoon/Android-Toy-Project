package com.example.unsplash.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.unsplash.core.database.dao.PhotoDao
import com.example.unsplash.core.database.model.PhotoDaoEntity

@Database(entities = [PhotoDaoEntity::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {
    internal abstract fun getPhotoDao(): PhotoDao
}