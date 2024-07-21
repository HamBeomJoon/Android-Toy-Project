package com.example.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PhotoDaoEntity::class], version = 1, exportSchema = false)
abstract class PhotoDatabase : RoomDatabase() {
    abstract fun getPhotoDao(): PhotoDao

    companion object {
        @Volatile
        private var INSTANCE: PhotoDatabase? = null

        private fun buildDatabase(context: Context): PhotoDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                PhotoDatabase::class.java,
                "bookmark-photos"
            ).build()

        fun getInstance(context: Context): PhotoDatabase =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
            }
    }
}