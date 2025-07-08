package com.exam.deepfine.data.datasource

import com.exam.deepfine.data.model.TodoItem
import kotlinx.coroutines.flow.Flow

interface TodoLocalDataSource {
    suspend fun insertItem(item: TodoItem)
    suspend fun updateItem(item: TodoItem)
    suspend fun deleteItem(item: TodoItem)
    fun selectItem(): Flow<List<TodoItem>>
}