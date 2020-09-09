package com.mahedi.mistplaychallenge.service.model

import com.google.gson.annotations.SerializedName

data class Games (

	@SerializedName("title") val title : String,
	@SerializedName("img") val img : String
)