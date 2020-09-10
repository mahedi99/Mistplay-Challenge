package com.mahedi.mistplaychallenge.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.service.model.GamesCategory
import com.mahedi.mistplaychallenge.service.model.HasType

/**
 * @author Mahedi Hassan
 * 2020-09-09
 */

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: HasType)
}