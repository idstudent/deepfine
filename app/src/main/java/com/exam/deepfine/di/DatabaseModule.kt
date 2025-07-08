package com.exam.deepfine.di

import android.app.Application
import androidx.room.Room
import com.exam.deepfine.data.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideTodoDatabase(app: Application) {
        Room.databaseBuilder(app, TodoDatabase::class.java, "todo_db")
            .fallbackToDestructiveMigration()
            .build()
    }
}