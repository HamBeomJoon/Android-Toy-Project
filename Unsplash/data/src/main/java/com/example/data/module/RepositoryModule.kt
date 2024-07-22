package com.example.data.module

import com.example.data.repository.PhotoRepositoryImpl
import com.example.domain.PhotoRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsPhotoRepository(photoRepositoryImpl: PhotoRepositoryImpl): PhotoRepository
//
//    @Binds
//    @Singleton
//    abstract fun bindsBookmarkRepository(
//        bookmarkRepositoryImpl: BookmarkRepositoryImpl
//    ): BookmarkRepository
}

