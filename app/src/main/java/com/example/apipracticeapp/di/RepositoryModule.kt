package com.example.apipracticeapp.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.apipracticeapp.domain.repository.PostRepository
import com.example.apipracticeapp.data.repository.PostRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindPostRepository(
        impl: PostRepositoryImpl
    ): PostRepository
}