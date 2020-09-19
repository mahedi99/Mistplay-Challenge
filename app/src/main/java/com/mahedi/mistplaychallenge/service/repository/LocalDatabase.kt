package com.mahedi.mistplaychallenge.service.repository

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.mahedi.mistplaychallenge.service.model.ChildrenDataObject
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.HasType
import com.mahedi.mistplaychallenge.service.model.ParentDataObject
import kotlinx.coroutines.delay
import java.io.IOException

/**
 * @author Mahedi Hassan
 * 2020-09-18
 */

//Source name of json data from asset folder
private const val SOURCE_FILE_NAME = "data.json"

class LocalDatabase(private val context: Context) {

    /**
     * Process data after fetching data from local JSON file and finally return data
     * to the repository
     */
    suspend fun getGames(): List<HasType> {
        val result = mutableListOf<HasType>()
        try {
            val jsonString: String = context.assets.open(SOURCE_FILE_NAME).bufferedReader().use {
                it.readText()
            }
            val data: List<GamesCategory> =  GsonBuilder().create()
                .fromJson(jsonString, object : TypeToken<List<GamesCategory>>() {
                }.type)
            for (tmpData in data){
                result.add(ParentDataObject(tmpData.list_title))
                result.add(ChildrenDataObject(tmpData.games))
            }
            return result

        }catch (e: IOException){
            Log.e(GamesRepository::class.java.simpleName, e.printStackTrace().toString())
        }
        return result
    }
}
