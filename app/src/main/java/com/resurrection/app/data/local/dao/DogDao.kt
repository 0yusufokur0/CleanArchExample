package com.resurrection.app.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.resurrection.app.data.local.entity.LastDogEntity

@Dao
interface DogDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDog(item: LastDogEntity)

    @Query("SELECT * FROM last_dog WHERE id = 0")
    suspend fun getLastDog(): LastDogEntity
}