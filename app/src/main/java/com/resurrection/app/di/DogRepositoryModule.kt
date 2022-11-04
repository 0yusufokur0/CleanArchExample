package com.resurrection.app.di

import com.resurrection.app.domain.repo.DogLocalRepository
import com.resurrection.app.data.repo.DogLocalRepositoryImpl
import com.resurrection.app.domain.repo.DogRemoteRepository
import com.resurrection.app.data.repo.DogRemoteRepositoryImpl
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
    abstract fun bindRemoteRepository(dogRemoteRepositoryImpl: DogRemoteRepositoryImpl): DogRemoteRepository

    @Binds
    @Singleton
    abstract fun bindLocalRepository(dogLocalRepositoryImpl: DogLocalRepositoryImpl): DogLocalRepository
}


