package com.mahedi.mistplaychallenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.R
import com.mahedi.mistplaychallenge.service.model.Games
import com.mahedi.mistplaychallenge.service.model.HasType
import com.mahedi.mistplaychallenge.util.loadImage

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * Nested adapter class to represent the row items. This adapter class is the part of the nested
 * recyclerview to show the images and titles for each game.
 */

class GameItemAdapter internal constructor(
    context: Context) : RecyclerView.Adapter<GameItemAdapter.GamesViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gamesCategoryList = emptyList<Games>()

    /**
     * The View Holder class is to render each item for the inner recyclerview. This class
     * is inherited from [RecyclerView.ViewHolder]
     */
    inner class GamesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameTitleTextView: TextView = itemView.findViewById(R.id.game_title)
        val gameImageView: ImageView = itemView.findViewById(R.id.game_image_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GamesViewHolder {
        val itemView = inflater.inflate(R.layout.game_item, parent, false)
        return GamesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: GamesViewHolder, position: Int) {
        val current = gamesCategoryList[position]
        holder.gameTitleTextView.text = current.title
        holder.gameImageView.loadImage(current.img)
    }

    internal fun setGameItems(games: List<Games>) {
        this.gamesCategoryList = games
        notifyDataSetChanged()
    }

    override fun getItemCount() = gamesCategoryList.size
}