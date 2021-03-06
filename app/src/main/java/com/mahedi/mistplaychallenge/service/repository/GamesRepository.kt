package com.mahedi.mistplaychallenge.service.repository

import android.content.Context
import androidx.lifecycle.LiveData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.HasType

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * Repository class plays the role of single source of data. Both local and remote data
 * is provided through this class
 */

class GamesRepository (private val localDatabase: LocalDatabase){

    /**
     * This method responses back to the ViewModel class [GamesViewModel] with a list of
     * [GamesCategory] data
     *
     * @return a list of [HasType] object
     */
    suspend fun getGames(): List<HasType>{
       return localDatabase.getGames()
    }
}