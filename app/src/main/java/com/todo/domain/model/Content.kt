package com.todo.domain.model

import java.io.Serializable

data class Content(

    val id: Int = 0,
    var content: String,
    var meno: String? = null,
    var isDone: Boolean = false

) : Serializable