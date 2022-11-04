package com.resurrection.app.data.remote.repo

import com.resurrection.app.data.model.DogResponseModel
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DogRemoteRepository {
    suspend fun getDog(): Flow<Resource<DogResponseModel>>
}