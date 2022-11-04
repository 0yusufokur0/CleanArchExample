package com.resurrection.app.domain.repo

import com.resurrection.app.data.model.dog.entity.LastDogEntity
import com.resurrection.app.data.model.dog.DogResponseModel
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DogLocalRepository {
    suspend fun insertDog(item: LastDogEntity)

    suspend fun getDog(): Flow<Resource<DogResponseModel>>
}