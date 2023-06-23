package com.todo.domain.repository

import com.todo.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList(): Flow<List<Content>>

    suspend fun insert(item: Content)
}