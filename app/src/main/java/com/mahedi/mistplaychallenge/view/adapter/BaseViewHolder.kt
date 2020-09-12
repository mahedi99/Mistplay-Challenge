package com.mahedi.mistplaychallenge.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.mahedi.mistplaychallenge.service.model.HasType

/**
 * @author Mahedi Hassan
 * 2020-09-09
 *
 * An abstract class for ViewHolders and a abstract method [bind] to be implemented in
 * the inherited classes
 */

abstract class BaseViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    abstract fun bind(data: HasType)
}