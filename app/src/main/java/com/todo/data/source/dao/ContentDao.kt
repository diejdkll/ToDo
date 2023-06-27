package com.todo.data.source.dao

import androidx.room.*
import com.todo.data.entity.ContentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ContentDao {

    @Query("SELECT * FROM Content")
    fun selectAll(): Flow<List<ContentEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: ContentEntity)

    @Delete
    suspend fun delete(item: ContentEntity)
}