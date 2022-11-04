package com.resurrection.app.ui.main

import androidx.lifecycle.viewModelScope
import com.resurrection.app.data.model.DogResponseModel
import com.resurrection.app.domain.GetDogUseCase
import com.resurrection.app.domain.SaveLastDogUseCase
import com.resurrection.base.core.viewmodel.BaseViewModel
import com.resurrection.base.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getDogUseCase: GetDogUseCase,
    private val saveLastDogUseCase: SaveLastDogUseCase,
) : BaseViewModel() {

    val dog = liveData<Resource<DogResponseModel>>()
    var dogJob: Job? = null
    fun getDog() {
        if (!networkManager.checkNetworkAvailable()) {
            dog.fetchData(request = getDogUseCase::invoke)
        } else {
            dogJob = viewModelScope.launch {
                repeat(Int.MAX_VALUE) {
                    dog.fetchData(request = getDogUseCase::invoke)
                    delay(1500)
                }
            }
        }
    }

    fun cancelDogJob(){
        dogJob?.cancel()
    }

    fun saveLastShownDog(lastShowedDogImageUrl: String) = viewModelScope.launch {
        saveLastDogUseCase.invoke(lastShowedDogImageUrl)
    }

}