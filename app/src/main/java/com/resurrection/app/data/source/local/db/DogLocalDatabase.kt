package com.resurrection.app.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.resurrection.app.data.source.local.dao.DogDao
import com.resurrection.app.data.model.dog.entity.LastDogEntity

@Database(
    entities = [LastDogEntity::class],
    version = 1,
    exportSchema = false
)
abstract class DogLocalDatabase : RoomDatabase() {
    abstract fun dogDao(): DogDao
}