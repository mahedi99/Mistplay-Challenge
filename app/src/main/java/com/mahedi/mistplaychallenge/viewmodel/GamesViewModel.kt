package com.mahedi.mistplaychallenge.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.mahedi.mistplaychallenge.service.model.ChildrenDataObject
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.HasType
import com.mahedi.mistplaychallenge.service.model.ParentDataObject
import com.mahedi.mistplaychallenge.service.repository.GamesRepository
import com.mahedi.mistplaychallenge.service.repository.LocalDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    private val repository: GamesRepository

    /**
     * This is the initialization of a MutableLiveData object which directly accessible to the UI
     *
     * @return a list of [HasType] MutableLiveData object
     */
    val data: LiveData<List<HasType>>


    /**
     * Initializing the local database, repository and livedata object
     */
    init {
        val localDatabase = LocalDatabase(application)
        repository = GamesRepository(localDatabase)
        data = liveData {
            emit(repository.getGames())
        }
    }
}
