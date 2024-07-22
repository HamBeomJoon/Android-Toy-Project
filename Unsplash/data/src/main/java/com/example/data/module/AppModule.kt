package com.example.data.module

import android.content.Context
import com.example.data.api.PhotoService
import com.example.data.api.RetrofitClient
import com.example.data.db.PhotoDao
import com.example.data.db.PhotoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePhotoService(): PhotoService {
        return RetrofitClient.getInstance().create(PhotoService::class.java)
    }

//    @Provides
//    @Singleton
//    fun providePhotoDatabase(@ApplicationContext context: Context): PhotoDatabase {
//        return PhotoDatabase.getInstance(context)
//    }
//
//    @Provides
//    fun providePhotoDao(photoDatabase: PhotoDatabase): PhotoDao {
//        return photoDatabase.getPhotoDao()
//    }
}