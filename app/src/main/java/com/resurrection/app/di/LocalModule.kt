package com.resurrection.app.di

import android.content.Context
import androidx.room.Room
import com.resurrection.app.data.local.dao.DogDao
import com.resurrection.app.data.local.db.DogLocalDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LocalModule {

    @Provides
    @Singleton
    fun provideFavoritesRoomDB(@ApplicationContext appContext: Context): DogLocalDatabase =
        Room.databaseBuilder(
            appContext,
            DogLocalDatabase::class.java,
            "main.db"
        ).build()

    @Provides
    @Singleton
    fun provideCoinsDAO(dogLocalDatabase: DogLocalDatabase): DogDao = dogLocalDatabase.dogDao()
}