package com.resurrection.app.data.repository

import com.resurrection.app.data.remote.DogApiService
import com.resurrection.app.util.resourcefulFlowOf
import retrofit2.Response
import javax.inject.Inject

class DogRemoteRepositoryImpl @Inject constructor(
    private val dogApiService: DogApiService
) : DogRemoteRepository {
    override suspend fun getDog() = resourcefulFlowOf(dogApiService::getDog)
}

