package com.exam.deepfine.data.repository

import com.exam.deepfine.data.datasource.TodoLocalDataSource
import com.exam.deepfine.data.model.TodoItem
import com.exam.deepfine.domain.repository.TodoDBRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoDBRepositoryImpl @Inject constructor(
    private val todoLocalDataSource: TodoLocalDataSource
): TodoDBRepository {
    override suspend fun insertItem(item: TodoItem) {
        todoLocalDataSource.insertItem(item)
    }

    override suspend fun updateItem(item: TodoItem) {
        todoLocalDataSource.updateItem(item)
    }

    override suspend fun deleteItem(item: TodoItem) {
        todoLocalDataSource.deleteItem(item)
    }

    override fun selectItem(): Flow<List<TodoItem>> {
        return todoLocalDataSource.selectItem()
    }
}