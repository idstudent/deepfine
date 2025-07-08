package com.exam.deepfine.di

import com.exam.deepfine.data.datasource.TodoLocalDataSource
import com.exam.deepfine.data.datasource.TodoLocalDataSourceImpl
import com.exam.deepfine.data.repository.TodoDBRepositoryImpl
import com.exam.deepfine.domain.repository.TodoDBRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TodoRepositoryModule {
    @Singleton
    @Binds
    abstract fun bindTodoDBRepository(
        impl: TodoDBRepositoryImpl
    ): TodoDBRepository

    @Singleton
    @Binds
    abstract fun bindTodoLocalDataSource(
        impl: TodoLocalDataSourceImpl
    ): TodoLocalDataSource
}