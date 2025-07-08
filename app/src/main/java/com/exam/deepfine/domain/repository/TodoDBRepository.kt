package com.exam.deepfine.domain.repository

import com.exam.deepfine.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoDBRepository {
    suspend fun insertItem(item: TodoItem)
    suspend fun updateItem(item: TodoItem)
    suspend fun deleteItem(item: TodoItem)
    fun selectItem(): Flow<List<TodoItem>>
}