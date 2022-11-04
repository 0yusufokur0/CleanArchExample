package com.resurrection.app.domain.usecase

import com.resurrection.app.data.model.dog.DogResponseModel
import com.resurrection.app.domain.repo.DogLocalRepository
import com.resurrection.app.domain.repo.DogRemoteRepository
import com.resurrection.base.components.network.NetworkManager
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetDogUseCase @Inject constructor(
    private val networkManager: NetworkManager,
    private val dogLocalRepository: DogLocalRepository,
    private val dogRemoteRepository: DogRemoteRepository,
) {
    suspend operator fun invoke(): Flow<Resource<DogResponseModel>> =
        if (!networkManager.checkNetworkAvailable()) {
            dogLocalRepository.getDog()
        } else{
            dogRemoteRepository.getDog()
        }
}