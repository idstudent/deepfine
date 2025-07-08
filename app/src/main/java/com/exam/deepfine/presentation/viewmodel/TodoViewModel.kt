package com.exam.deepfine.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.exam.deepfine.domain.usecase.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import androidx.lifecycle.viewModelScope
import com.exam.deepfine.data.model.TodoItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
): ViewModel() {
    private val _todos = MutableStateFlow<List<TodoItem>>(emptyList())
    val todos = _todos.asStateFlow()

    fun getTodos() {
        viewModelScope.launch {
            todoUseCase.getTodos().collect {
                _todos.value = it
            }
        }
    }

    fun insertItem(item: TodoItem) {
        viewModelScope.launch {
            todoUseCase.insertItem(item)
        }
    }

    fun updateItem(item: TodoItem) {
        viewModelScope.launch {
            todoUseCase.updateItem(item.copy(isCompleted = true, completedTimeStamp = System.currentTimeMillis()))
        }
    }

    fun deleteItem(item: TodoItem) {
        viewModelScope.launch {
            todoUseCase.deleteItem(item)
        }
    }
}