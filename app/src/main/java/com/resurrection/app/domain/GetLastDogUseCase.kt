package com.resurrection.app.domain

import com.resurrection.app.data.local.entity.LastDogEntity
import com.resurrection.app.data.model.DogResponseModel
import com.resurrection.app.data.repository.DogLocalRepository
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetLastDogUseCase @Inject constructor(
    private val dogLocalRepository: DogLocalRepository
) {
    suspend operator fun invoke(): Flow<Resource<DogResponseModel>> {
        return dogLocalRepository.getDog()
    }
}