package com.mahedi.mistplaychallenge.view.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.R
import com.mahedi.mistplaychallenge.view.adapter.GameCategoryAdapter
import com.mahedi.mistplaychallenge.viewmodel.GamesViewModel


/**
 * This is the launcher activity class. This activity is loaded immediately
 * It is responsible for showing a list component with the other helper classes
 */

class GamesActivity : AppCompatActivity() {

    /**
     * Declaring the [GameCategoryAdapter] adapter object for recyclerview
     */
    private lateinit var adapter: GameCategoryAdapter

    /**
     * Declaring the [GamesViewModel] object
     */
    private lateinit var gamesViewModel: GamesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_games)

        initRecyclerView()

        gamesViewModel = GamesViewModel(application)
        gamesViewModel.getGames()
        gamesViewModel.data.observe(this, Observer { data ->
            adapter.setGamesCategory(data)
        })
    }

    /**
     * Initializing the RecyclerView and the Adapter for the parent view
     * which represents the GameCategory
     */
    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.game_category_recycler_view)
        adapter = GameCategoryAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}