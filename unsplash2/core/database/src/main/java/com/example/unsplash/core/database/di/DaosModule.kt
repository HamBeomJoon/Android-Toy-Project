package com.example.unsplash.core.database.di

import com.example.unsplash.core.database.PhotoDatabase
import com.example.unsplash.core.database.dao.PhotoDao
import dagger.Provides

internal object DaosModule {

    @Provides
    fun providesPhotoDao(
        database: PhotoDatabase,
    ): PhotoDao = database.getPhotoDao()
}