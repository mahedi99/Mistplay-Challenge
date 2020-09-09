package com.mahedi.mistplaychallenge.service.model

import com.google.gson.annotations.SerializedName

data class GamesCategory (

	@SerializedName("list_title") val list_title : String,
	@SerializedName("games") val games : List<Games>
)