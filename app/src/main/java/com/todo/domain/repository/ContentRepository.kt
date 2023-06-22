package com.todo.domain.repository

import com.todo.domain.model.Content

interface ContentRepository {

    suspend fun insert(item: Content)
}