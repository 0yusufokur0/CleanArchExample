package com.resurrection.app.data.repo

import com.resurrection.app.data.source.remote.DogApiService
import com.resurrection.app.domain.repo.DogRemoteRepository
import com.resurrection.app.util.resourcefulFlowOf
import javax.inject.Inject

class DogRemoteRepositoryImpl @Inject constructor(
    private val dogApiService: DogApiService
) : DogRemoteRepository {

    override suspend fun getDog() = resourcefulFlowOf(dogApiService::getDog)

}

