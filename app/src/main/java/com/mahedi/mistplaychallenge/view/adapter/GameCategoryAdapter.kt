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
 */
class GameCategoryAdapter internal constructor(
    context: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gameCategory = emptyList<HasType>()



    inner class CategoryViewHolder(itemView: View) : BaseViewHolder(itemView) {
        private val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
        override fun bind(data: HasType) {
            val tmpData = data as ParentDataObject
            categoryItemTextView.text = tmpData.title
        }
    }

    inner class GamesViewHolder(itemView: View) : BaseViewHolder(itemView) {
//        val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
        private lateinit var adapter: GameItemAdapter
        override fun bind(data: HasType) {
//            val gameItemAdapter = GameItemAdapter(appl)
//            with(itemView){
//                setVariable(BR.adapter, nestedAdapter)
//            }
            val tmpData = data as ChildrenDataObject
            initRecyclerRV()
            adapter.setGameItems(tmpData.nestedDataObjectList)
        }

        private fun initRecyclerRV(){
            val recyclerView = itemView.findViewById<RecyclerView>(R.id.nestedRecyclerView)
            adapter = GameItemAdapter(itemView.context)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
        }
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            Holder.PARENT.type -> CategoryViewHolder(inflater.inflate(R.layout.game_category_item, parent, false))
            Holder.NESTED.type -> GamesViewHolder(inflater.inflate(R.layout.games, parent, false))
            else -> throw IllegalArgumentException("You must supply a valid type for this adapter")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        val current = gamesCategoryList[position]
//        holder.categoryItemTextView.text = current.list_title
        holder.bind(gameCategory[position])
    }

    internal fun setGamesCategory(gameCategory: List<HasType>) {
        this.gameCategory = gameCategory
        notifyDataSetChanged()
    }

    override fun getItemCount() = gameCategory.size

    override fun getItemViewType(position: Int): Int {
        return position % 2 * 2
    }
}
























/*
class GameCategoryAdapter internal constructor(
    context: Context) : RecyclerView.Adapter<GameCategoryAdapter.CategoryViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gamesCategoryList = emptyList<GameCategory>()



    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val itemView = inflater.inflate(R.layout.game_category_item, parent, false)
        return CategoryViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val current = gamesCategoryList[position]
        holder.categoryItemTextView.text = current.list_title
    }

    internal fun setGamesCategory(gameCategory: List<GameCategory>) {
        this.gamesCategoryList = gameCategory
        notifyDataSetChanged()
    }

    override fun getItemCount() = gamesCategoryList.size
}*/
