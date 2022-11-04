package com.resurrection.app.data.remote.repo

import com.resurrection.app.data.remote.service.DogApiService
import com.resurrection.app.util.resourcefulFlowOf
import javax.inject.Inject

class DogRemoteRepositoryImpl @Inject constructor(
    private val dogApiService: DogApiService
) : DogRemoteRepository {
    override suspend fun getDog() = resourcefulFlowOf(dogApiService::getDog)
}

