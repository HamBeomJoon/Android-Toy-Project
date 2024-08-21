package com.example.presentation.di

import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindsPhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository
//
//    @Binds
//    @Singleton
//    abstract fun bindsBookmarkRepository(bookmarkRepositoryImpl: BookmarkRepositoryImpl): BookmarkRepository
}

