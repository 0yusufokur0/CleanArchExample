package com.resurrection.app.data.model

import com.google.gson.annotations.SerializedName

data class DogResponseModel(

	@field:SerializedName("message")
	var message: String? = null,

	@field:SerializedName("status")
	val status: String? = null
)
