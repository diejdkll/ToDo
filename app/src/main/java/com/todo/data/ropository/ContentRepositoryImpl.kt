package com.todo.data.ropository

import com.todo.data.mapper.ContentMapper.toEntity
import com.todo.data.source.dao.ContentDao
import com.todo.domain.model.Content
import com.todo.domain.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentDao: ContentDao
) : ContentRepository {

    override suspend fun insert(item: Content) {
        contentDao.insert(item.toEntity())
    }
}