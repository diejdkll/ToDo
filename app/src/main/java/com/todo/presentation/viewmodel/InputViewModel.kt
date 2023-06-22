package com.todo.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.todo.domain.model.Content
import com.todo.domain.usecase.ContentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InputViewModel @Inject constructor(
    private val contentUseCase: ContentUseCase
) : ViewModel() {

    private val _doneEvent = MutableLiveData<Pair<Boolean, String>>()
    val doneEvent: LiveData<Pair<Boolean, String>> = _doneEvent

    var content = MutableLiveData<String>()
    var meno = MutableLiveData<String?>()
    private var item: Content? = null

    fun initData(item: Content) {
        this.item = item
        content.value = item.content
        meno.value = item.meno
    }

    fun insertData() {
        val contentValue = content.value
        val menoValue = meno.value

        if (contentValue.isNullOrBlank()) {
            _doneEvent.value = Pair(false, "할일을 입력해주세요!")
            return
        } else {
            viewModelScope.launch(Dispatchers.IO) {
                contentUseCase.insert(
                    item?.copy(
                        content = contentValue,
                        meno = menoValue
                    ) ?: Content(
                        content = contentValue,
                        meno = menoValue,
                    )
                ).also { _doneEvent.postValue(Pair(true, if (it as Boolean) "완료!" else "저장 할 수 없습니다.")) }
            }
        }
    }
}