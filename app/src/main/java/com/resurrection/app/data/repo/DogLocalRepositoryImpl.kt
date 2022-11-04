package com.resurrection.app.data.repo

import com.resurrection.app.data.source.local.dao.DogDao
import com.resurrection.app.data.model.dog.entity.LastDogEntity
import com.resurrection.app.data.source.local.mapper.toDogResponseModel
import com.resurrection.app.data.model.dog.DogResponseModel
import com.resurrection.app.domain.repo.DogLocalRepository
import com.resurrection.app.util.resourcefulFlowOf
 import com.resurrection.base.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DogLocalRepositoryImpl @Inject constructor(
    private val dogDao: DogDao
) : DogLocalRepository {

    override suspend fun insertDog(item: LastDogEntity) = dogDao.insertDog(item)

    override suspend fun getDog(): Flow<Resource<DogResponseModel>> = resourcefulFlowOf {
        dogDao.getLastDog().toDogResponseModel()
    }

}