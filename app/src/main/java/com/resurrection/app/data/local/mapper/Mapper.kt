package com.resurrection.app.data.local.mapper

import com.resurrection.app.data.local.entity.LastDogEntity
import com.resurrection.app.data.model.DogResponseModel

fun LastDogEntity.toDogResponseModel(): DogResponseModel {
    return DogResponseModel(message = this.url)
}