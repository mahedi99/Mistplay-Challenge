package com.mahedi.mistplaychallenge.service.repository

import android.content.Context
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.mahedi.mistplaychallenge.service.model.GamesCategory

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * Repository class plays the role of single source of data. Both local and remote data
 * is provided through this class
 */

class GamesRepository (private val context: Context){

    /**
     * This companion object is only accessible within the class only, the constant inside the
     * companion object contains the name of the json file name
     */
    companion object {
        private const val SOURCE_FILE_NAME = "data.json"
    }


    /**
     * This method responses back to the ViewModel class [GamesViewModel] with a list of
     * [GamesCategory] data
     *
     * @return a list of [GamesCategory] object
     */
    fun getGames(): List<GamesCategory> {
        val jsonString = context.assets.open(SOURCE_FILE_NAME).bufferedReader().use{
            it.readText()
        }

        return GsonBuilder().create()
            .fromJson(jsonString, object : TypeToken<List<GamesCategory>>() {}.type)
    }
}