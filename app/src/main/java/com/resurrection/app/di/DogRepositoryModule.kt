package com.resurrection.app.di

import com.resurrection.app.data.repository.DogLocalRepository
import com.resurrection.app.data.repository.DogLocalRepositoryImpl
import com.resurrection.app.data.repository.DogRemoteRepository
import com.resurrection.app.data.repository.DogRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DogRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRemoteRepository(dogRemoteRepositoryImpl: DogRemoteRepositoryImpl):DogRemoteRepository

    @Binds
    @Singleton
    abstract fun bindLocalRepository(dogLocalRepositoryImpl: DogLocalRepositoryImpl):DogLocalRepository
}


