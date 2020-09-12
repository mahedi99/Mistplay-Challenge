package com.mahedi.mistplaychallenge.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.mahedi.mistplaychallenge.R

/**
 * @author Mahedi Hassan
 * 2020-09-08
 *
 * Utils file for the common tasks/work to be written for the whole module
 */



/**
 * This method is to load any image using [Glide] library. Accessible anywhere in the module
 */
fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .centerCrop()
        .error(R.mipmap.ic_launcher)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}