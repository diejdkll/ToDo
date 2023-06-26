package com.todo.data.ropository

import com.todo.data.mapper.ContentMapper.toContent
import com.todo.data.mapper.ContentMapper.toEntity
import com.todo.data.source.dao.ContentDao
import com.todo.domain.model.Content
import com.todo.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentDao: ContentDao
) : ContentRepository {

    override fun loadList(): Flow<List<Content>> {
        return flow {
            contentDao.selectAll().collect { list ->
                emit(list.map { it.toContent() })
            }
        }
    }

    override suspend fun insert(item: Content): Boolean {
        return try {
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }

    override suspend fun modify(item: Content): Boolean {
        return try {
            contentDao.insert(item.toEntity())
            true
        } catch (e: IOException) {
            false
        }
    }
}