package com.todo.di.module

import com.todo.data.ropository.ContentRepositoryImpl
import com.todo.data.source.dao.ContentDao
import com.todo.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesContentRepository(contentDao: ContentDao): ContentRepository
    = ContentRepositoryImpl(contentDao)
}