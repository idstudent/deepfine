package com.exam.deepfine.di

import android.app.Application
import androidx.room.Room
import com.exam.deepfine.data.db.TodoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SupportFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Singleton
    @Provides
    fun provideTodoDatabase(app: Application): TodoDatabase {
        val key = "deep_fine_key".toByteArray()
        val factory = SupportFactory(key)

        return Room.databaseBuilder(app, TodoDatabase::class.java, "todo_db")
            .openHelperFactory(factory)
            .build()
    }
}