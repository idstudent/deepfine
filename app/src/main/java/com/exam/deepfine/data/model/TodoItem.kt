package com.exam.deepfine.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo")
data class TodoItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String,
    val addTimeStamp: Long = System.currentTimeMillis(),
    val isCompleted: Boolean = false,
    val completedTimeStamp: Long? = null
)
