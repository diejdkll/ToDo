package com.todo.data.source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.todo.data.entity.ContentEntity
import com.todo.data.source.dao.ContentDao

@Database(entities = [ContentEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao
}