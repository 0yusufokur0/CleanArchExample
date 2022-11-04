package com.resurrection.app.domain.usecase

import com.resurrection.app.data.model.dog.entity.LastDogEntity
import com.resurrection.app.domain.repo.DogLocalRepository
import javax.inject.Inject

class SaveLastDogUseCase @Inject constructor(
     private val dogLocalRepository: DogLocalRepository
) {
    suspend operator fun invoke(url:String) = dogLocalRepository.insertDog(LastDogEntity(url = url))
}
