package com.exam.deepfine.di

import com.exam.deepfine.domain.repository.TodoDBRepository
import com.exam.deepfine.domain.usecase.TodoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class TodoUseCaseModule {
    @Singleton
    @Provides
    fun provideTodoUseCase(todoDBRepository: TodoDBRepository): TodoUseCase {
        return TodoUseCase(todoDBRepository)
    }
}