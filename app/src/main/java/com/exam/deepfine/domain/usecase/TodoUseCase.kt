package com.exam.deepfine.domain.usecase

import com.exam.deepfine.data.model.TodoItem
import com.exam.deepfine.domain.repository.TodoDBRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val todoDBRepository: TodoDBRepository
) {
    suspend fun insertItem(item: TodoItem) {
        todoDBRepository.insertItem(item)
    }

    suspend fun updateItem(item: TodoItem) {
        todoDBRepository.updateItem(item)
    }

    suspend fun deleteItem(item: TodoItem) {
        todoDBRepository.deleteItem(item)
    }

    suspend fun getTodos(): Flow<List<TodoItem>> {
        return todoDBRepository.selectItem()
    }
}