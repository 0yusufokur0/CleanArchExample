package com.resurrection.app.data.source.remote

import com.resurrection.app.data.model.dog.DogResponseModel
import retrofit2.http.GET

interface DogApiService {
    @GET("api/breeds/image/random")
    suspend fun getDog() : DogResponseModel
}