package com.resurrection.app.domain.repo

import com.resurrection.app.data.model.dog.DogResponseModel
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DogRemoteRepository {
    suspend fun getDog(): Flow<Resource<DogResponseModel>>
}