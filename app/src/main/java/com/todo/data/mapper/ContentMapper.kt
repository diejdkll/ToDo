package com.todo.data.mapper

import com.todo.data.entity.ContentEntity
import com.todo.domain.model.Content

object ContentMapper {

    fun Content.toEntity() = ContentEntity(
        id = id,
        content = content,
        meno = meno,
        isDone = isDone
    )
}