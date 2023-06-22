package com.todo.di.module

import com.todo.data.source.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Provides
    @Singleton
    fun providesContentDao(appDatabase: AppDatabase) = appDatabase.contentDao()
}