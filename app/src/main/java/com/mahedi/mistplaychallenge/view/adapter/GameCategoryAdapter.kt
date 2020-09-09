package com.mahedi.mistplaychallenge.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.R
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.Holder

/**
 * @author Mahedi Hassan
 * 2020-09-08
 */
class GameCategoryAdapter internal constructor(
    context: Context) : RecyclerView.Adapter<BaseViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var gameCategory = emptyList<GamesCategory>()



    inner class CategoryViewHolder(itemView: View) : BaseViewHolder(itemView) {
        val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
        override fun bind(data: GamesCategory) {
            categoryItemTextView.text = data.list_title
        }
    }

    inner class GamesViewHolder(itemView: View) : BaseViewHolder(itemView) {
//        val categoryItemTextView: TextView = itemView.findViewById(R.id.category_title)
        override fun bind(data: GamesCategory) {
//            categoryItemTextView.text = data.list_title
        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when(viewType){
            Holder.PARENT.type -> CategoryViewHolder(inflater.inflate(R.layout.game_category_item, parent, false))
            Holder.NESTED.type -> GamesViewHolder(inflater.inflate(R.layout.game_item, parent, false))
            else -> throw IllegalArgumentException("You must supply a valid type for this adapter")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
//        val current = gamesCategoryList[position]
//        holder.categoryItemTextView.text = current.list_title
        holder.bind(gameCategory[position])
    }

    internal fun setGamesCategory(gameCategory: List<GamesCategory>) {
        this.gameCategory = gameCategory
        notifyDataSetChanged()
    }

    override fun getItemCount() = gameCategory.size
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
