package com.todo.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.todo.domain.usecase.ContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val contentUseCase: ContentUseCase
) : ViewModel() {

    val contentList = contentUseCase.loadList()
}