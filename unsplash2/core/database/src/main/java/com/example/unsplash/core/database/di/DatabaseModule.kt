package com.example.unsplash.core.database.di

import android.content.Context
import androidx.room.Room
import com.example.unsplash.core.database.PhotoDatabase
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

internal object DatabaseModule {

    @Provides
    @Singleton
    fun providesPhotoDatabase(
        @ApplicationContext context: Context,
    ): PhotoDatabase = Room.databaseBuilder(
        context,
        PhotoDatabase::class.java,
        "bookmark-photos",
    ).build()
}