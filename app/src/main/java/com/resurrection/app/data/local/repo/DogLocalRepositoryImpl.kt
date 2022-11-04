package com.resurrection.app.data.local.repo

import com.resurrection.app.data.local.dao.DogDao
import com.resurrection.app.data.local.entity.LastDogEntity
import com.resurrection.app.data.local.mapper.toDogResponseModel
import com.resurrection.app.data.model.DogResponseModel
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