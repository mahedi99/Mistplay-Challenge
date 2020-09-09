package com.mahedi.mistplaychallenge.service.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.mahedi.mistplaychallenge.service.model.GamesCategory

/**
 * @author Mahedi Hassan
 * 2020-09-08
 */

class GamesRepository (private val context: Context){
    companion object {
        private const val SOURCE_FILE_NAME = "data.json"
    }

    fun getGames(): List<GamesCategory> {
        val jsonString = context.assets.open(SOURCE_FILE_NAME).bufferedReader().use{
            it.readText()
        }

        return GsonBuilder().create()
            .fromJson(jsonString, object : TypeToken<List<GamesCategory>>() {}.type)
    }
}