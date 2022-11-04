package com.resurrection.app.domain

import com.resurrection.app.data.model.DogResponseModel
import com.resurrection.app.data.local.repo.DogLocalRepository
import com.resurrection.app.data.remote.repo.DogRemoteRepository
import com.resurrection.base.components.network.NetworkManager
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class GetDogUseCase @Inject constructor(
    private val networkManager: NetworkManager,
    private val dogLocalRepository: DogLocalRepository,
    private val dogRemoteRepository: DogRemoteRepository,
) {
    suspend operator fun invoke(): Flow<Resource<DogResponseModel>> {
        if (!networkManager.checkNetworkAvailable()) {
            val data : Flow<Resource<DogResponseModel>>
            return dogLocalRepository.getDog()
        } else{
            return dogRemoteRepository.getDog()/*.transform {
                if (it.data?.status != "success") {
                    it.data?.message = "https://images.dog.ceo/breeds/bulldog-french/n02108915_5667.jpg"
                }
            }*/
        }
    }
}