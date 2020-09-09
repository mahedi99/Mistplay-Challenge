package com.mahedi.mistplaychallenge.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.repository.GamesRepository

/**
 * @author Mahedi Hassan
 * 2020-09-08
 */

class GamesViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: GamesRepository = GamesRepository(application)
    val data: MutableLiveData<List<GamesCategory>> by lazy {
        MutableLiveData<List<GamesCategory>>()
    }

    fun getGames() {
        data.postValue(repository.getGames())
    }
}
