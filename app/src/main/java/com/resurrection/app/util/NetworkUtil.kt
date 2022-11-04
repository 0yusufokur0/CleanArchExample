package com.resurrection.app.util

import com.resurrection.app.data.model.dog.entity.LastDogEntity
import com.resurrection.base.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn


fun <T> resourcefulFlowOf(request: suspend () -> T) = flow {
    val response = try {
        Resource.Success(request.invoke())
    } catch (e: Exception) {
        Resource.Error(e)
    }
    emit(response)
}