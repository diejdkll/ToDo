package com.todo.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Content")
data class ContentEntity(

    @PrimaryKey(true)
    val id: Int = 0,

    @ColumnInfo
    var content: String,

    @ColumnInfo
    var meno: String? = null,

    @ColumnInfo
    var isDone: Boolean = false

) : Serializable