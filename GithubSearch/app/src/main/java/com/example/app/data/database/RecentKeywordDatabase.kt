package com.example.app.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RecentKeywordEntity::class], version = 1)
abstract class RecentKeywordDatabase : RoomDatabase() {
    abstract fun recentKeywordDao(): RecentKeywordDao

    companion object {
        private const val DB_NAME = "recent_keywords"

        @Volatile
        private var instance: RecentKeywordDatabase? = null

        fun getInstance(context: Context): RecentKeywordDatabase =
            instance ?: synchronized(this) {
                instance ?: createDatabase(context).also { instance = it }
            }

        private fun createDatabase(context: Context): RecentKeywordDatabase =
            Room
                .databaseBuilder(
                    context.applicationContext,
                    RecentKeywordDatabase::class.java,
                    DB_NAME,
                ).build()
    }
}
