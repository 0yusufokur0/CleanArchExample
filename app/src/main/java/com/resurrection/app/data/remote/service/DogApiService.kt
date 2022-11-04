package com.resurrection.app.data.remote.service

import com.resurrection.app.data.model.DogResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface DogApiService {
    @GET("api/breeds/image/random")
    suspend fun getDog() :DogResponseModel
}