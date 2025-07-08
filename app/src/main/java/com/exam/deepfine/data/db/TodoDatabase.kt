package com.exam.deepfine.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.exam.deepfine.data.model.TodoItem

@Database(entities = [TodoItem::class], version = 1)
abstract class TodoDatabase: RoomDatabase() {
    abstract fun todoDao(): TodoDao
    
    companion object {
        fun newInstance(context: Context): TodoDatabase {
            return Room.databaseBuilder(context, TodoDatabase::class.java, "todo_db")
                .fallbackToDestructiveMigration()
                .build()
        } 
    }
}