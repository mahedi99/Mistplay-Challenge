package com.mahedi.mistplaychallenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.R
import com.mahedi.mistplaychallenge.service.model.*

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * This adapter class is to show the list of game categories which holds two different types of
 * views. The first view is to show the title of the game category, the second view itself is a
 * list of games. The second view of this adapter holds a nested recyclerview.
 */
class GameCategoryAdapter internal constructor(
    context: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gameCategory = emptyList<HasType>()



    /**
     * The parent view holder represents the title of the game category which is inherited
     * from [BaseViewHolder]
     */
    inner class CategoryViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
        override fun bind(data: HasType) {
            val tmpData = data as ParentDataObject
            categoryItemTextView.text = tmpData.title
        }
    }

    /**
     * The child view holder to render the nested recyclerview using anther adopter
     * class [GameItemAdapter] which is inherited from [BaseViewHolder]
     */
    inner class GamesViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private lateinit var adapter: GameItemAdapter
        override fun bind(data: HasType) {
            val tmpData = data as ChildrenDataObject
            initRecyclerView()
            adapter.setGameItems(tmpData.nestedDataObjectList)
        }

        private fun initRecyclerView(){
            val recyclerView = itemView.findViewById<RecyclerView>(R.id.nestedRecyclerView)
            adapter = GameItemAdapter(itemView.context)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            Holder.PARENT.type -> CategoryViewHolder(inflater.inflate(R.layout.game_category_item, parent, false))
            Holder.CHILD.type -> GamesViewHolder(inflater.inflate(R.layout.games, parent, false))
            else -> throw IllegalArgumentException("invalid type of adapter")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.bind(gameCategory[position])
    }

    internal fun setGamesCategory(gameCategory: List<HasType>) {
        this.gameCategory = gameCategory
        notifyDataSetChanged()
    }

    override fun getItemCount() = gameCategory.size

    override fun getItemViewType(position: Int): Int {
        return gameCategory.get(position).getType()
    }
}