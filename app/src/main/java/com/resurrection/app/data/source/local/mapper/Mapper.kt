package com.resurrection.app.data.source.local.mapper

import com.resurrection.app.data.model.dog.entity.LastDogEntity
import com.resurrection.app.data.model.dog.DogResponseModel

fun LastDogEntity.toDogResponseModel(): DogResponseModel {
    return DogResponseModel(message = this.url)
}