package com.mahedi.mistplaychallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mahedi.mistplaychallenge.service.model.ChildrenDataObject
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.HasType
import com.mahedi.mistplaychallenge.service.model.ParentDataObject
import com.mahedi.mistplaychallenge.service.repository.GamesRepository

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * This class is the bridge between the UI and repository and most importantly holds the LiveData
 * object for the UI. Is it inherited from [AndroidViewModel] class
 */

class GamesViewModel(application: Application) : AndroidViewModel(application) {

    /**
     * This is the initialization of [GamesRepository] object to have access to the repository
     */
    private val repository: GamesRepository = GamesRepository(application)

    /**
     * This is the initialization of a MutableLiveData object which directly accessible to the UI
     *
     * @return a list of [HasType] MutableLiveData object
     */
    val data: MutableLiveData<List<HasType>> by lazy {
        MutableLiveData<List<HasType>>()
    }


    /**
     * This method is makes a request to the repository for a list of data call back.
     * Directly accessible to the UI
     */
    fun getGames() {
        val result = repository.getGames()
        result?.let {
            val myData = mutableListOf<HasType>()
            for (d in result){
                myData.add(ParentDataObject(d.list_title))
                myData.add(ChildrenDataObject(d.games))
            }
            data.postValue(myData)
        }
    }
}
