package com.exam.deepfine.data.datasource

import com.exam.deepfine.data.db.TodoDatabase
import com.exam.deepfine.data.model.TodoItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoLocalDataSourceImpl @Inject constructor(
    private val todoDatabase: TodoDatabase
): TodoLocalDataSource {
    override suspend fun insertItem(item: TodoItem) {
        return todoDatabase.todoDao().insertItem(item)
    }

    override suspend fun updateItem(item: TodoItem) {
        return todoDatabase.todoDao().updateItem(item)
    }

    override suspend fun deleteItem(item: TodoItem) {
        return todoDatabase.todoDao().deleteItem(item)
    }

    override fun selectItem(): Flow<List<TodoItem>> {
        return todoDatabase.todoDao().selectItem()
    }
}