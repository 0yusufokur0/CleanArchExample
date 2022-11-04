package com.resurrection.app.di

import com.resurrection.app.data.remote.service.DogApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

    const val BASE_URL = "https://dog.ceo/" //TODO:Move to configration

    @Provides
    @Singleton
    fun provideDogApiService(): DogApiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
         .build()
        .create(DogApiService::class.java)
}