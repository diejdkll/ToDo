package com.todo.domain.usecase

import com.todo.domain.model.Content
import com.todo.domain.repository.ContentRepository
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository
) {

    fun loadList() = contentRepository.loadList()

    suspend fun insert(item: Content) = contentRepository.insert(item)
}